package db.model;

public class Client {
  private Long id;
  private String name;
  private String mail;
  private String password;
  private Long roleId; // зовнішній ключ до Role.id

  public Client() {
  }

  public Client(Long id, String name, String mail, String password, Long roleId) {
    this.id = id;
    this.name = name;
    this.mail = mail;
    this.password = password;
    this.roleId = roleId;
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

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  @Override
  public String toString() {
    return "Client{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", mail='" + mail + '\'' +
            ", password='" + password + '\'' +
            ", roleId=" + roleId +
            '}';
  }
}
