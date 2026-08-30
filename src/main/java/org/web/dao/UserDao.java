package org.web.dao;

import org.web.model.User;

import java.util.List;


public interface UserDao {
    User findById(long id);

    void save(User user);

    void updateById(User user);

    List<User> findAll(Integer count);

    void deleteById(long id);
}
