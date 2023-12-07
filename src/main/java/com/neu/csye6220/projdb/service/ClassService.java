package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.ClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("classService")
public class ClassService extends ServiceBase {

  @Autowired
  private ClassDao classDao;

}
