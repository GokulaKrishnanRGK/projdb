package com.neu.csye6220.projdb.controller;

import com.neu.csye6220.projdb.constant.Role;
import com.neu.csye6220.projdb.entity.Class;
import com.neu.csye6220.projdb.entity.Login;
import com.neu.csye6220.projdb.entity.Login.LoginEnum;
import com.neu.csye6220.projdb.entity.User;
import com.neu.csye6220.projdb.service.LoginService;
import com.neu.csye6220.projdb.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserManagementController {

  private static final Logger logger = LoggerFactory.getLogger(UserManagementController.class);

  private final UserService userService;
  private final LoginService loginService;

  public UserManagementController(UserService userService, LoginService loginService) {
    this.userService = userService;
    this.loginService = loginService;
  }

  @GetMapping("/get-users")
  public ModelAndView getUsers() {
    String[] headers = {"Firstname", "Lastname", "Email", "Profile"};
    String[] colNames = {"firstname", "lastname", "email", "profile"};
    List<User> users = userService.get(User.class);
    Map<String, Object> resp = new HashMap<>();
    resp.put("tableHeaders", headers);
    resp.put("colNames", colNames);
    resp.put("title", "Get users");
    resp.put("users", users);
    return new ModelAndView("users-view", resp);
  }

  @GetMapping("/register")
  public ModelAndView viewRegisterPage() {
    return new ModelAndView("register-view");
  }

  @PostMapping("/register")
  public ModelAndView register(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName,
      @RequestParam String profile, @RequestParam String password, @RequestParam String confirmPassword) {
    List<String> msg = new ArrayList<>();
    if (loginService.getUnique(Login.class, LoginEnum.EMAIL.getColName(), email) != null) {
      msg.add("user.register.email.exist");
    }
    if (!password.equals(confirmPassword)) {
      msg.add("user.register.password.mismatch");
    }
    String[] split = email.split("@");
    if (!split[split.length - 1].equals("northeastern.edu")) {
      msg.add("user.register.email.org.mismatch");
    }
    if (msg.isEmpty()) {
      User user = new User(firstName, lastName, Role.STUDENT, profile, email);
      userService.save(user);
      Login login = new Login(email, password, user);
      loginService.save(login);
      msg.add("user.register.success");
    }
    Map<String, Object> resp = new HashMap<>();
    resp.put("message", msg);
    return new ModelAndView("redirect:/register-view", "resp", resp);
  }

  @PostMapping("/delete-user")
  public ModelAndView deleteUser(@RequestParam Long classId){
    User user = userService.getById(User.class, classId);
    userService.delete(user);
    return new ModelAndView("success-view","Success", "success delete user");
  }

}
