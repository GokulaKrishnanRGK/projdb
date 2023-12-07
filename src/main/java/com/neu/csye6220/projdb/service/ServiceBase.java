package com.neu.csye6220.projdb.service;

import com.neu.csye6220.projdb.dao.DaoBase;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceBase {

  @Autowired
  private DaoBase daoBase;

  public <T> List<T> get(Class clzz) {
    return daoBase.get(clzz);
  }

  public <T> List<T> get(Class clzz, String col, String val) {
    return daoBase.get(clzz, col, val);
  }

  public <T> T getUnique(Class clzz, String col, String val) {
    return daoBase.getUnique(clzz, col, val);
  }

  public <T> T getById(Class clzz, Long id) {
    return daoBase.getListByIn(clzz, id);
  }

  public <T> List<T> getListByIn(Class clzz, String col, List<Long> vals) {
    return daoBase.getListByIn(clzz, col, vals);
  }

  public <T> void save(T t) {
    daoBase.save(t);
  }

  public <T> void update(T t) {
    daoBase.update(t);
  }

  public <T> void delete(T t) {
    daoBase.delete(t);
  }

}
