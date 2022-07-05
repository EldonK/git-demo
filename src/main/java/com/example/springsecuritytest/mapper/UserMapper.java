package com.example.springsecuritytest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecuritytest.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author k2001
 * Date 2022/6/30 11:57
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
}
