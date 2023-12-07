package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.IssueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("issueService")
public class IssueService extends ServiceBase {

  @Autowired
  private IssueDao issueDao;

}
