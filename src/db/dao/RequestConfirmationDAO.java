package db.dao;

import db.model.RequestConfirmation;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestConfirmationDAO implements GenericDAO<RequestConfirmation, Long> {

  private static final String INSERT_SQL =
          "INSERT INTO RequestConfirmation (answer, time, Client_id) VALUES (?, ?, ?)";
  private static final String SELECT_BY_ID_SQL =
          "SELECT id, answer, time, Client_id FROM RequestConfirmation WHERE id = ?";
  private static final String SELECT_ALL_SQL =
          "SELECT id, answer, time, Client_id FROM RequestConfirmation";
  private static final String UPDATE_SQL =
          "UPDATE RequestConfirmation SET answer = ?, time = ?, Client_id = ? WHERE id = ?";
  private static final String DELETE_SQL =
          "DELETE FROM RequestConfirmation WHERE id = ?";

  @Override
  public Optional<RequestConfirmation> findById(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
      ps.setLong(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          RequestConfirmation rc = new RequestConfirmation();
          rc.setId(rs.getLong("id"));
          rc.setAnswer(rs.getInt("answer") == 1);
          rc.setTime(rs.getTimestamp("time").toLocalDateTime());
          rc.setClientId(rs.getLong("Client_id"));
          return Optional.of(rc);
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<RequestConfirmation> findAll() throws Exception {
    List<RequestConfirmation> list = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        RequestConfirmation rc = new RequestConfirmation();
        rc.setId(rs.getLong("id"));
        rc.setAnswer(rs.getInt("answer") == 1);
        rc.setTime(rs.getTimestamp("time").toLocalDateTime());
        rc.setClientId(rs.getLong("Client_id"));
        list.add(rc);
      }
    }
    return list;
  }

  @Override
  public Long create(RequestConfirmation rc) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
      ps.setInt(1, rc.getAnswer() ? 1 : 0);
      ps.setTimestamp(2, Timestamp.valueOf(rc.getTime()));
      ps.setLong(3, rc.getClientId());
      int affected = ps.executeUpdate();

      if (affected == 0) {
        throw new SQLException("Creating request confirmation failed, no rows affected.");
      }

      try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getLong(1);
        }
        else {
          throw new SQLException("Creating request confirmation failed, no ID obtained.");
        }
      }
    }
  }

  @Override
  public boolean update(RequestConfirmation rc) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
      ps.setInt(1, rc.getAnswer() ? 1 : 0);
      ps.setTimestamp(2, Timestamp.valueOf(rc.getTime()));
      ps.setLong(3, rc.getClientId());
      ps.setLong(4, rc.getId());
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