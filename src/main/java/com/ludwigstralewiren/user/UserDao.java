package com.ludwigstralewiren.user;

import java.util.List;

/**
 * Created by Ludwig on 9/18/2016.
 */
public interface UserDao {
    List<User>findAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void delete(User user);

}
