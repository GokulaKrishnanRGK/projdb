package com.neu.csye6220.projdb.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends DaoBase {

  private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

  @Autowired
  private SessionFactory sessionFactory;



}
