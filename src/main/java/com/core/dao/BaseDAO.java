package com.core.dao;

import java.util.List;

public interface BaseDAO<T> {
    void create(T entity);
    T read(String login);
    void update(T entity);
    void delete(T entity);
    List<T> getAll();
}
