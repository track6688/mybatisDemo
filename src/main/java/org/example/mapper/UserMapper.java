package org.example.dao;

import org.example.domain.User;

public interface UserMapper {

    User selectById(Integer id);

    int updateUser(User user);

}
