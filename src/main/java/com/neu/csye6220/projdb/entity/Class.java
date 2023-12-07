package com.neu.csye6220.projdb.entity;

import com.neu.csye6220.projdb.constant.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="class")
public class Class {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="class_id")
  private Long classId;

  @Column(name="title")
  private String title;

  @Column(name="description")
  private String description;

  @Column(name="term")
  private String term;

  @Column(name="status")
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name="teacher_id")
  private Long teacherId; //mapped to user table - ID column

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name="Fk_class_students"))
  private List<User> students =  new ArrayList<>();

  @Transient
  private User teacher;

  public Class() {
  }

  public Class(String title, String description, String term, Status status) {
    this.title = title;
    this.description = description;
    this.term = term;
    this.status = status;
  }

  public Long getClassId() {
    return classId;
  }

  public void setClassId(Long classId) {
    this.classId = classId;
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

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public User getTeacher() {
    return teacher;
  }

  public void setTeacher(User teacher) {
    this.teacher = teacher;
  }

  public List<User> getStudents() {
    return students;
  }

  public void setStudents(List<User> students) {
    this.students = students;
  }

  public void addStudent(User student){
    this.students.add(student);
  }

  public void addStudent(List<User> students){
    this.students.addAll(students);
  }

  public Long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(Long teacherId) {
    this.teacherId = teacherId;
  }
}
