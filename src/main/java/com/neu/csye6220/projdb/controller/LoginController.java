package com.neu.csye6220.projdb.controller;

import com.neu.csye6220.projdb.entity.Login;
import com.neu.csye6220.projdb.entity.Login.LoginEnum;
import com.neu.csye6220.projdb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

  final UserService userService;

  public LoginController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public ModelAndView index() {
    return new ModelAndView("redirect:/login");
  }

  @GetMapping("/login")
  public ModelAndView viewLoginPage() {
    return new ModelAndView("login-view");
  }

  @PostMapping("/login")
  public ModelAndView loginUser(@RequestParam String email, String password, HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    Login dbLogin = userService.getUnique(Login.class, LoginEnum.EMAIL.getColName(), email);
    if (dbLogin == null) {
      modelAndView.setViewName("redirect:/login");
      modelAndView.addObject("error", "email-wrong");
    } else {
      if (password.equals(dbLogin.getPassword())) {
        request.getSession().setAttribute("login", dbLogin);
        modelAndView.setViewName("redirect:/get-classes");
      } else {
        modelAndView.setViewName("redirect:/login");
        modelAndView.addObject("error", "password-wrong");
      }
    }
    return modelAndView;
  }

  @GetMapping("/logout")
  public String handleLogout(HttpServletRequest request) {
    request.getSession().invalidate();
    return "redirect:/";
  }
}
