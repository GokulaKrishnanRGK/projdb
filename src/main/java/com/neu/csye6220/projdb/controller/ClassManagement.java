package com.neu.csye6220.projdb.controller;

import com.neu.csye6220.projdb.constant.Role;
import com.neu.csye6220.projdb.constant.Status;
import com.neu.csye6220.projdb.entity.Class;
import com.neu.csye6220.projdb.entity.User;
import com.neu.csye6220.projdb.service.ClassService;
import com.neu.csye6220.projdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassManagement {

  @Autowired
  ClassService classService;

  @Autowired
  UserService userService;

  @GetMapping("/get-classes")
  public ModelAndView getClasses() {
    String[] headers = {"Title", "Description", "Term"};
    String[] colNames = {"title", "description", "term"};
    List<Class> classes = classService.get(Class.class);
    Map<String, Object> resp = new HashMap<>();
    resp.put("tableHeaders", headers);
    resp.put("colNames", colNames);
    resp.put("title", "Get classes");
    resp.put("classes", classes);
    return new ModelAndView("classes-view", resp);
  }

  @PostMapping("/add-students")
  public ModelAndView addStudents(@RequestParam Long classId, @RequestParam List<Long> studentIds) {
    Class clzz = classService.getById(Class.class, classId);
    List<User> students = userService.getListByIn(User.class, "userId", studentIds);
    clzz.addStudent(students);
    classService.save(clzz);
    List<String> messages = buildClassSuccessResponseTemplate(clzz.getTitle(), clzz.getDescription(), clzz.getTerm());
    messages.add("Successfully added students to class!");
    Map<String, Object> resp = new HashMap<>();
    resp.put("messages", messages);
    return new ModelAndView("success-view", resp);
  }

  @GetMapping("/create-class")
  public ModelAndView getCreateClassView() {
    List<User> students = userService.get(User.class);
    students = students.stream().filter(x -> x.getRole().equals(Role.STUDENT)).collect(Collectors.toList());
    Map<String, Object> resp = new HashMap<>();
    resp.put("students", students);
    return new ModelAndView("new-class-view", resp);
  }

  @PostMapping("/create-class")
  public ModelAndView createClass(@RequestParam String className, @RequestParam String description, @RequestParam String term,
      @RequestParam List<Long> studentIds, HttpServletRequest req) {
    Class clzz = new Class(className, description, term, Status.OPEN);
    List<User> students = userService.getListByIn(User.class, "userId", studentIds);
    User teacher = (User) req.getSession().getAttribute("user");
    clzz.setTeacherId(teacher.getUserId());
    clzz.setStudents(students);
    classService.save(clzz);
    List<String> messages = buildClassSuccessResponseTemplate(clzz.getTitle(), clzz.getDescription(), clzz.getTerm());
    messages.add("Successfully added new class!");
    Map<String, Object> resp = new HashMap<>();
    resp.put("messages", messages);
    return new ModelAndView("success-view", resp);
  }

  @PostMapping("/delete-class")
  public ModelAndView deleteClass(@RequestParam Long classId) {
    Class clzz = classService.getById(Class.class, classId);
    classService.delete(clzz);
    List<String> messages = buildClassSuccessResponseTemplate(clzz.getTitle(), clzz.getDescription(), clzz.getTerm());
    Map<String, Object> resp = new HashMap<>();
    resp.put("messages", messages);
    return new ModelAndView("success-view", resp);
  }

  private static List<String> buildClassSuccessResponseTemplate(String className, String description, String term) {
    List<String> messages = new ArrayList<>();
    messages.add("Classname: " + className);
    messages.add("Description: " + description);
    messages.add("Term: " + term);
    return messages;
  }
}
