package com.persistence;

import com.core.dao.UserDAO;
import com.core.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Override
    public User getUserByLogin(String login) {
        return (User)getSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .list().get(0);
    }

    @Override
    public List<User> getAllUsers() {
        return getSession()
                .createCriteria(User.class)
                .list();
    }
}
