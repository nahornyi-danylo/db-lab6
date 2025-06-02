package db.dao;

import db.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAO implements GenericDAO<Client, Long> {

  private static final String INSERT_SQL =
          "INSERT INTO Client (name, mail, password, Role_id) VALUES (?, ?, ?, ?)";
  private static final String SELECT_BY_ID_SQL =
          "SELECT id, name, mail, password, Role_id FROM Client WHERE id = ?";
  private static final String SELECT_ALL_SQL =
          "SELECT id, name, mail, password, Role_id FROM Client";
  private static final String UPDATE_SQL =
          "UPDATE Client SET name = ?, mail = ?, password = ?, Role_id = ? WHERE id = ?";
  private static final String DELETE_SQL =
          "DELETE FROM Client WHERE id = ?";

  @Override
  public Optional<Client> findById(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
      ps.setLong(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Client c = new Client();
          c.setId(rs.getLong("id"));
          c.setName(rs.getString("name"));
          c.setMail(rs.getString("mail"));
          c.setPassword(rs.getString("password"));
          c.setRoleId(rs.getLong("Role_id"));
          return Optional.of(c);
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Client> findAll() throws Exception {
    List<Client> clients = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Client c = new Client();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        c.setMail(rs.getString("mail"));
        c.setPassword(rs.getString("password"));
        c.setRoleId(rs.getLong("Role_id"));
        clients.add(c);
      }
    }
    return clients;
  }

  @Override
  public Long create(Client client) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, client.getName());
      ps.setString(2, client.getMail());
      ps.setString(3, client.getPassword());
      ps.setLong(4, client.getRoleId());
      int affected = ps.executeUpdate();

      if (affected == 0) {
        throw new SQLException("Creating client failed, no rows affected.");
      }

      try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getLong(1);
        }
        else {
          throw new SQLException("Creating client failed, no ID obtained.");
        }
      }
    }
  }

  @Override
  public boolean update(Client client) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
      ps.setString(1, client.getName());
      ps.setString(2, client.getMail());
      ps.setString(3, client.getPassword());
      ps.setLong(4, client.getRoleId());
      ps.setLong(5, client.getId());
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