package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentService extends ServiceBase {

  @Autowired
  private CommentDao commentDao;

}
