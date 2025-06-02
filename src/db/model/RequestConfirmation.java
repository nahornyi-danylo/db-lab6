package db.model;

import java.time.LocalDateTime;

public class RequestConfirmation {
  private Long id;
  private Boolean answer;
  private LocalDateTime time;
  private Long clientId;        // зовнішній ключ до Client.id

  public RequestConfirmation() {
  }

  public RequestConfirmation(Long id, Boolean answer, LocalDateTime time, Long clientId) {
    this.id = id;
    this.answer = answer;
    this.time = time;
    this.clientId = clientId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getAnswer() {
    return answer;
  }

  public void setAnswer(Boolean answer) {
    this.answer = answer;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  @Override
  public String toString() {
    return "RequestConfirmation{" +
            "id=" + id +
            ", answer=" + answer +
            ", time=" + time +
            ", clientId=" + clientId +
            '}';
  }
}
