package org.web.service;

import org.web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll(Integer count);

    void save(User user);

    void updateById(User user);

    User findById(long id);

    void deleteById(long id);
}
