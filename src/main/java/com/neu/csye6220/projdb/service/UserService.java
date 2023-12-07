package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.UserDao;
import com.neu.csye6220.projdb.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService extends ServiceBase {

  @Autowired
  private UserDao userDao;

}