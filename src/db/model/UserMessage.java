package db.model;

import java.time.LocalDateTime;

public class UserMessage {
  private Long id;
  private String text;
  private LocalDateTime time;
  private Long requestConfirmationId;         // зовнішній ключ до RequestConfirmation.id
  private Long requestConfirmationClientId;   // зовнішній ключ до RequestConfirmation.client_id

  public UserMessage() {
  }

  public UserMessage(Long id, String text, LocalDateTime time, Long requestConfirmationId, Long requestConfirmationClientId) {
    this.id = id;
    this.text = text;
    this.time = time;
    this.requestConfirmationId = requestConfirmationId;
    this.requestConfirmationClientId = requestConfirmationClientId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public Long getRequestConfirmationId() {
    return requestConfirmationId;
  }

  public void setRequestConfirmationId(Long requestConfirmationId) {
    this.requestConfirmationId = requestConfirmationId;
  }

  public Long getRequestConfirmationClientId() {
    return requestConfirmationClientId;
  }

  public void setRequestConfirmationClientId(Long requestConfirmationClientId) {
    this.requestConfirmationClientId = requestConfirmationClientId;
  }

  @Override
  public String toString() {
    return "UserMessage{" +
            "id=" + id +
            ", text='" + text + '\'' +
            ", time=" + time +
            ", requestConfirmationId=" + requestConfirmationId +
            ", requestConfirmationClientId=" + requestConfirmationClientId +
            '}';
  }
}
