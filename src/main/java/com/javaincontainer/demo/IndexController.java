package com.javaincontainer.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class IndexController {
  @Value("${database.url}")
  String url;
  @Value("${database.username}")
  String username;
  @Value("${database.password}")
  String password;

  @GetMapping("/")
  public String greeting() throws SQLException {
    String sqlSelectAllPersons = "SELECT * FROM GreetingsTable";

    Connection conn = DriverManager.getConnection(url, username, password);
     PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
     ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        String test = rs.getString("greeting");
        return test;
      }

    return ":(";
  }
}
