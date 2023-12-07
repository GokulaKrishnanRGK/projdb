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
@Table(name="issue")
public class Issue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="issue_id")
  private Long issueId;

  @Column(name="projectId")
  private Long projectId; //To map project table - ID

  @Column(name="creatorId")
  private Long creatorId; //To map user table - ID

  @Column(name="title")
  private String title;

  @Column(name="description")
  private String decription;

  @Column(name="status")
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name="time")
  private Timestamp time;

  public Issue() {
  }

  public Issue(Long issueId, Long projectId, Long creatorId, String title, String decription, Status status, Timestamp time) {
    this.issueId = issueId;
    this.projectId = projectId;
    this.creatorId = creatorId;
    this.title = title;
    this.decription = decription;
    this.status = status;
    this.time = time;
  }

  public Long getIssueId() {
    return issueId;
  }

  public void setIssueId(Long issue_id) {
    this.issueId = issue_id;
  }

  public Long getProjectId() {
    return projectId;
  }

  public void setProjectId(Long projectId) {
    this.projectId = projectId;
  }

  public Long getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(Long creatorId) {
    this.creatorId = creatorId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDecription() {
    return decription;
  }

  public void setDecription(String decription) {
    this.decription = decription;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
