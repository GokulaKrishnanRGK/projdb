package com.neu.csye6220.projdb.entity;

import com.neu.csye6220.projdb.constant.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="project")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="project_id")
  private Long projectId;

  @Column(name="title")
  private String title;

  @Column(name="description")
  private String description;

  @Column(name="status")
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name="message")
  private String message;

  @Column(name="creator")
  private Long creator; //map project creator ID - typically teacher

  @Column(name="time")
  private Timestamp time;

  public Project() {
  }

  public Project(Long projectId, String title, String description, Status status, String message, Long creator, Timestamp time) {
    this.projectId = projectId;
    this.title = title;
    this.description = description;
    this.status = status;
    this.message = message;
    this.creator = creator;
    this.time = time;
  }

  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long project_id) {
    this.projectId = project_id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getCreator() {
    return creator;
  }

  public void setCreator(Long creator) {
    this.creator = creator;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
