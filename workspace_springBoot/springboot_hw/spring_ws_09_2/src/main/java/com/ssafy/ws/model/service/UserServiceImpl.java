package com.ssafy.ws.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.User;

/**
 * 빈으로 등록될 수 있도록 @Service를 선언한다.
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User select(String id) {
        return userDao.select(id);
    }
}
