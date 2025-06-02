package db.dao;

import db.model.Task;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskDAO implements GenericDAO<Task, Long> {

  private static final String INSERT_SQL =
          "INSERT INTO Task (name, deadline, Client_id) VALUES (?, ?, ?)";
  private static final String SELECT_BY_ID_SQL =
          "SELECT id, name, deadline, Client_id FROM Task WHERE id = ?";
  private static final String SELECT_ALL_SQL =
          "SELECT id, name, deadline, Client_id FROM Task";
  private static final String UPDATE_SQL =
          "UPDATE Task SET name = ?, deadline = ?, Client_id = ? WHERE id = ?";
  private static final String DELETE_SQL =
          "DELETE FROM Task WHERE id = ?";

  @Override
  public Optional<Task> findById(Long id) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_SQL)) {
      ps.setLong(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Task t = new Task();
          t.setId(rs.getLong("id"));
          t.setName(rs.getString("name"));
          Timestamp ts = rs.getTimestamp("deadline");
          if (ts != null) {
            t.setDeadline(ts.toLocalDateTime());
          }
          t.setClientId(rs.getLong("Client_id"));
          return Optional.of(t);
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Task> findAll() throws Exception {
    List<Task> tasks = new ArrayList<>();
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(SELECT_ALL_SQL);
         ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Task t = new Task();
        t.setId(rs.getLong("id"));
        t.setName(rs.getString("name"));
        Timestamp ts = rs.getTimestamp("deadline");
        if (ts != null) {
          t.setDeadline(ts.toLocalDateTime());
        }
        t.setClientId(rs.getLong("Client_id"));
        tasks.add(t);
      }
    }
    return tasks;
  }

  @Override
  public Long create(Task task) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, task.getName());
      if (task.getDeadline() != null) {
        ps.setTimestamp(2, Timestamp.valueOf(task.getDeadline()));
      }
      else {
        ps.setTimestamp(2, null);
      }
      ps.setLong(3, task.getClientId());
      int affected = ps.executeUpdate();

      if (affected == 0) {
        throw new SQLException("Creating task failed, no rows affected.");
      }

      try (ResultSet keys = ps.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getLong(1);
        }
        else {
          throw new SQLException("Creating task failed, no ID obtained.");
        }
      }
    }
  }

  @Override
  public boolean update(Task task) throws Exception {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
      ps.setString(1, task.getName());
      if (task.getDeadline() != null) {
        ps.setTimestamp(2, Timestamp.valueOf(task.getDeadline()));
      }
      else {
        ps.setTimestamp(2, null);
      }
      ps.setLong(3, task.getClientId());
      ps.setLong(4, task.getId());
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