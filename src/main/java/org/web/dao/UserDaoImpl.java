package org.web.dao;

import org.springframework.transaction.annotation.Transactional;
import org.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll(Integer count) {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void updateById(User user) {
        entityManager.merge(user);
    }
}
