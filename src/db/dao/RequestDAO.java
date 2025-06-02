package db.dao;

import db.model.Request;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestDAO implements GenericDAO<Request, Long> {

  private static final String INSERT_SQL =
          "INSERT INTO Request (name, time, description, Client_id) VALUES (?, ?, ?, ?)";
  private static final String SELECT_BY_ID_SQL =
          "SELECT id, name, time, description, Client_id FROM Request WHERE id = ?";
  private static final String SELECT_ALL_SQL =
          "SELECT id, name, time, description, Client_id FROM Request";
  private static final String UPDATE_SQL =
          "UPDATE Request SET name = ?, time = ?, description = ?, Client_id = ? WHERE id = ?";
  private static final String DELETE_SQL =
          "DELETE FROM Request WHERE id = ?";

  @Override
  public Optional<Request> findById(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
      ps.setLong(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Request r = new Request();
          r.setId(rs.getLong("id"));
          r.setName(rs.getString("name"));
          r.setTime(rs.getTimestamp("time").toLocalDateTime());
          r.setDescription(rs.getString("description"));
          r.setClientId(rs.getLong("Client_id"));
          return Optional.of(r);
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Request> findAll() throws Exception {
    List<Request> requests = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Request r = new Request();
        r.setId(rs.getLong("id"));
        r.setName(rs.getString("name"));
        r.setTime(rs.getTimestamp("time").toLocalDateTime());
        r.setDescription(rs.getString("description"));
        r.setClientId(rs.getLong("Client_id"));
        requests.add(r);
      }
    }
    return requests;
  }

  @Override
  public Long create(Request request) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, request.getName());
      ps.setTimestamp(2, Timestamp.valueOf(request.getTime()));
      ps.setString(3, request.getDescription());
      ps.setLong(4, request.getClientId());
      int affected = ps.executeUpdate();

      if (affected == 0) {
        throw new SQLException("Creating request failed, no rows affected.");
      }

      try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getLong(1);
        }
        else {
          throw new SQLException("Creating request failed, no ID obtained.");
        }
      }
    }
  }

  @Override
  public boolean update(Request request) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
      ps.setString(1, request.getName());
      ps.setTimestamp(2, Timestamp.valueOf(request.getTime()));
      ps.setString(3, request.getDescription());
      ps.setLong(4, request.getClientId());
      ps.setLong(5, request.getId());
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