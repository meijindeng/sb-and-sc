package com.coast.controller;


import com.coast.entity.User;
import com.coast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("getAllUser")
    public List<User> GetAllUser(){
        return userService.selectAllUser();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.selectUserById(id).toString();
    }
}

