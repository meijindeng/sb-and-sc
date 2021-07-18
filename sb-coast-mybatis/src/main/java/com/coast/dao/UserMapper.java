package com.coast.dao;


import com.coast.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT * FROM user")
    List<User> selectAllUser();

    /**
     * 根据id查询用户
     * @return
     */
    User selectUserById(int id);


}
