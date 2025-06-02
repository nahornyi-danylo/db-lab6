package db.model;

import java.time.LocalDateTime;

public class Request {
  private Long id;
  private String name;
  private LocalDateTime time;
  private String description;
  private Long clientId; // зовнішній ключ до Client.id

  public Request() {
  }

  public Request(Long id, String name, LocalDateTime time, String description, Long clientId) {
    this.id = id;
    this.name = name;
    this.time = time;
    this.description = description;
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

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  @Override
  public String toString() {
    return "Request{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", time=" + time +
            ", description='" + description + '\'' +
            ", clientId=" + clientId +
            '}';
  }
}
