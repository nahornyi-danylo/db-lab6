package db.dao;

import db.model.UserMessage;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMessageDAO implements GenericDAO<UserMessage, Long> {

  private static final String INSERT_SQL =
          "INSERT INTO UserMessage (text, time, RequestConfirmation_id, RequestConfirmation_Client_id) VALUES (?, ?, ?, ?)";
  private static final String SELECT_BY_ID_SQL =
          "SELECT id, text, time, RequestConfirmation_id, RequestConfirmation_Client_id FROM UserMessage WHERE id = ?";
  private static final String SELECT_ALL_SQL =
          "SELECT id, text, time, RequestConfirmation_id, RequestConfirmation_Client_id FROM UserMessage";
  private static final String UPDATE_SQL =
          "UPDATE UserMessage SET text = ?, time = ?, RequestConfirmation_id = ?, RequestConfirmation_Client_id = ? WHERE id = ?";
  private static final String DELETE_SQL =
          "DELETE FROM UserMessage WHERE id = ?";

  @Override
  public Optional<UserMessage> findById(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
      ps.setLong(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          UserMessage um = new UserMessage();
          um.setId(rs.getLong("id"));
          um.setText(rs.getString("text"));
          um.setTime(rs.getTimestamp("time").toLocalDateTime());
          um.setRequestConfirmationId(rs.getLong("RequestConfirmation_id"));
          um.setRequestConfirmationClientId(rs.getLong("RequestConfirmation_Client_id"));
          return Optional.of(um);
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<UserMessage> findAll() throws Exception {
    List<UserMessage> list = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        UserMessage um = new UserMessage();
        um.setId(rs.getLong("id"));
        um.setText(rs.getString("text"));
        um.setTime(rs.getTimestamp("time").toLocalDateTime());
        um.setRequestConfirmationId(rs.getLong("RequestConfirmation_id"));
        um.setRequestConfirmationClientId(rs.getLong("RequestConfirmation_Client_id"));
        list.add(um);
      }
    }
    return list;
  }

  @Override
  public Long create(UserMessage um) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, um.getText());
      ps.setTimestamp(2, Timestamp.valueOf(um.getTime()));
      ps.setLong(3, um.getRequestConfirmationId());
      ps.setLong(4, um.getRequestConfirmationClientId());
      int affected = ps.executeUpdate();

      if (affected == 0) {
        throw new SQLException("Creating user message failed, no rows affected.");
      }

      try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getLong(1);
        }
        else {
          throw new SQLException("Creating user message failed, no ID obtained.");
        }
      }
    }
  }

  @Override
  public boolean update(UserMessage um) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
      ps.setString(1, um.getText());
      ps.setTimestamp(2, Timestamp.valueOf(um.getTime()));
      ps.setLong(3, um.getRequestConfirmationId());
      ps.setLong(4, um.getRequestConfirmationClientId());
      ps.setLong(5, um.getId());
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