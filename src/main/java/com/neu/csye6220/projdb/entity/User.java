package com.neu.csye6220.projdb.entity;

import com.neu.csye6220.projdb.constant.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="user_id")
  private Long userId;

  @Column(name="firstname")
  private String firstname;

  @Column(name="lastname")
  private String lastname;

  @Column(name="role")
  @Enumerated(EnumType.STRING)
  private Role role;

  @Column(name="profile")
  private String profile;

  @Column(name="email")
  private String email;

  public User() {
  }

  public User(String firstname, String lastname, Role role, String profile, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.role = role;
    this.profile = profile;
    this.email = email;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long user_id) {
    this.userId = user_id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
