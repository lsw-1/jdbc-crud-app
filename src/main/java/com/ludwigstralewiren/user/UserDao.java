package com.ludwigstralewiren.user;

import java.util.List;


public interface UserDao {
    List<User>findAll();
    User findById(Long id);
    void save(User user);
    void delete(User user);
    List findUserByName(String name);

}
