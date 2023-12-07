package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("projectService")
public class ProjectService extends ServiceBase {

  @Autowired
  private ProjectDao projectDao;

}
