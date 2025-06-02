package db.dao;

import db.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDAO implements GenericDAO<Role, Long> {

  private static final String INSERT_SQL =
          "INSERT INTO Role (name, permission, description) VALUES (?, ?, ?)";
  private static final String SELECT_BY_ID_SQL =
          "SELECT id, name, permission, description FROM Role WHERE id = ?";
  private static final String SELECT_ALL_SQL =
          "SELECT id, name, permission, description FROM Role";
  private static final String UPDATE_SQL =
          "UPDATE Role SET name = ?, permission = ?, description = ? WHERE id = ?";
  private static final String DELETE_SQL =
          "DELETE FROM Role WHERE id = ?";

  @Override
  public Optional<Role> findById(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
      ps.setLong(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Role r = new Role();
          r.setId(rs.getLong("id"));
          r.setName(rs.getString("name"));
          r.setPermission(rs.getString("permission"));
          r.setDescription(rs.getString("description"));
          return Optional.of(r);
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Role> findAll() throws Exception {
    List<Role> roles = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Role r = new Role();
        r.setId(rs.getLong("id"));
        r.setName(rs.getString("name"));
        r.setPermission(rs.getString("permission"));
        r.setDescription(rs.getString("description"));
        roles.add(r);
      }
    }
    return roles;
  }

  @Override
  public Long create(Role role) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, role.getName());
      ps.setString(2, role.getPermission());
      ps.setString(3, role.getDescription());
      int affected = ps.executeUpdate();

      if (affected == 0) {
        throw new SQLException("Creating role failed, no rows affected.");
      }

      try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getLong(1);
        } else {
          throw new SQLException("Creating role failed, no ID obtained.");
        }
      }
    }
  }

  @Override
  public boolean update(Role role) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
      ps.setString(1, role.getName());
      ps.setString(2, role.getPermission());
      ps.setString(3, role.getDescription());
      ps.setLong(4, role.getId());

      int affected = ps.executeUpdate();
      return affected > 0;
    }
  }

  @Override
  public boolean delete(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {
      ps.setLong(1, id);
      int affected = ps.executeUpdate();
      return affected > 0;
    }
  }
}