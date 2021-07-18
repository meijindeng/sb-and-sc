package com.coast.service;



import com.coast.dao.UserMapper;
import com.coast.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAllUser(){
        return userMapper.selectAllUser();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }
}
