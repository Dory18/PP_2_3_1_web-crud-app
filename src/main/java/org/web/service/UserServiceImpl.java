package org.web.service;

import org.web.dao.UserDao;
import org.web.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);

    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAll(Integer count) {
        return userDao.findAll(count);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void updateById(User user) {
        userDao.updateById(user);
    }
}
