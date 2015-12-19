package com.core.service;

import com.core.dao.BaseDAO;

public interface UserService extends BaseDAO {
    void addUser(String name, String login, String password);
    void updateUser(String login, String newName);
    void removeUser(String login);
}
