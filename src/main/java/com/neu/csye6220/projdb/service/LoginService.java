package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService extends ServiceBase  {

  @Autowired
  private LoginDao loginDao;

}
