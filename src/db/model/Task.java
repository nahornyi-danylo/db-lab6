package db.model;

import java.time.LocalDateTime;

public class Task {
  private Long id;
  private String name;
  private LocalDateTime deadline;
  private Long clientId; // зовнішній ключ до Client.id

  public Task() {
  }

  public Task(Long id, String name, LocalDateTime deadline, Long clientId) {
    this.id = id;
    this.name = name;
    this.deadline = deadline;
    this.clientId = clientId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  @Override
  public String toString() {
    return "Task{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", deadline=" + deadline +
            ", clientId=" + clientId +
            '}';
  }
}
