package com.neu.csye6220.projdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="comment_id")
  private Long commentId;

  @Column(name="comment")
  private String comment;

  @Column(name="issueId")
  private String issueId;

  @Column(name="time")
  private Timestamp time;

  public Comment() {
  }

  public Comment(Long commentId, String comment, String issueId, Timestamp time) {
    this.commentId = commentId;
    this.comment = comment;
    this.issueId = issueId;
    this.time = time;
  }

  public Long getCommentId() {
    return commentId;
  }

  public void setCommentId(Long comment_id) {
    this.commentId = comment_id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getIssueId() {
    return issueId;
  }

  public void setIssueId(String issueId) {
    this.issueId = issueId;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
