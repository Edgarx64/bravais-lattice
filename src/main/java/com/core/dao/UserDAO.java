package com.core.dao;

import com.core.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {
    User getUserByLogin(String login);
    List getAllUsers();
}
