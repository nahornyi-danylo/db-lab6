package db.model;

public class Role {
  private Long id;
  private String name;
  private String permission;
  private String description;

  public Role() {
  }

  public Role(Long id, String name, String permission, String description) {
    this.id = id;
    this.name = name;
    this.permission = permission;
    this.description = description;
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

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", permission='" + permission + '\'' +
            ", description='" + description + '\'' +
            '}';
  }
}
