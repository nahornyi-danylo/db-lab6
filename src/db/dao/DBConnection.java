package db.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
  private static final String PROPS_FILE = "/db.properties";
  private static String url;
  private static String user;
  private static String password;
  private static String driver;

  static {
    try (InputStream in = DBConnection.class.getResourceAsStream(PROPS_FILE)) {
      Properties props = new Properties();
      props.load(in);

      url = props.getProperty("jdbc.url");
      user = props.getProperty("jdbc.user");
      password = props.getProperty("jdbc.password");
      driver = props.getProperty("jdbc.driver");

      Class.forName(driver);
    }
    catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      throw new ExceptionInInitializerError("Cannot load DB properties");
    }
  }

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }
}
