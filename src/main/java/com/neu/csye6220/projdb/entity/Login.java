package com.neu.csye6220.projdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

  public enum LoginEnum {

    ID("login_id"),
    EMAIL("email");

    private String colName;

    LoginEnum(String colName) {
      this.colName = colName;
    }

    public String getColName() {
      return colName;
    }
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "login_id")
  private Long loginId;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "Fk_login_user"))
  private User user;

  public Login() {
  }

  public Login(String email, String password, User user) {
    this.email = email;
    this.password = password;
    this.user = user;
  }

  public Long getLoginId() {
    return loginId;
  }

  public void setLoginId(Long loginId) {
    this.loginId = loginId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
