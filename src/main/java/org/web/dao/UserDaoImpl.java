package org.web.dao;

import org.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void deleteById(long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }


    @Override
    public List<User> findAll(Integer count) {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public void updateById(User user) {
        entityManager.merge(user);
    }
}
