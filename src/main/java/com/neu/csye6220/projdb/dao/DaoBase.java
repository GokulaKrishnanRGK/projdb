package com.neu.csye6220.projdb.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoBase {

  private static final Logger logger = LoggerFactory.getLogger(DaoBase.class);

  @Autowired
  private SessionFactory sessionFactory;

  public <T> List<T> get(Class clzz) {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("from " + clzz.getSimpleName(), clzz).list();
    } catch (Exception e) {
      logger.error("Exception while fetching users: ", e);
    }
    return null;
  }

  public <T> List<T> get(Class clzz, String col, String val) {
    try (Session session = sessionFactory.openSession()) {
      String query = "from " + clzz.getSimpleName() + " where " + col + " = :val";
      return session.createQuery(query, clzz).setParameter("val", val).list();
    } catch (Exception e) {
      logger.error("Exception while get by param: ", e);
    }
    return null;
  }

  public <T> T getUnique(Class clzz, String col, String val) {
    try (Session session = sessionFactory.openSession()) {
      String query = "from " + clzz.getSimpleName() + " where " + col + " = :val";
      return (T) session.createQuery(query, clzz).setParameter("val", val).uniqueResult();
    } catch (Exception e) {
      logger.error("Exception while get by param: ", e);
    }
    return null;
  }

  public <T> T getListByIn(Class clzz, Long id) {
    try (Session session = sessionFactory.openSession()) {
      return (T) session.get(clzz, id);
    } catch (Exception e) {
      logger.error("Exception while get by id: ", e);
    }
    return null;
  }

  public <T> List<T> getListByIn(Class clzz, String col, List<Long> vals) {
    try (Session session = sessionFactory.openSession()) {
      String query = "from " + clzz.getSimpleName() + " where " + col + " IN :val";
      return session.createQuery(query, clzz).setParameter("val", vals).list();
    }
  }

  public <T> void save(T t) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.persist(t);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      logger.error("Exception while saving t, ", e);
    }
  }

  public <T> void update(T t) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.merge(t);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      logger.error("Exception while saving t, ", e);
    }
  }

  public <T> void delete(T t) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.remove(t);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      logger.error("Exception while deleting t, ", e);
    }
  }

}
