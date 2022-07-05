package com.example.springsecuritytest.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springsecuritytest.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserDetialsServiceImp
 * @Description TODO
 * @Author k2001
 * Date 2022/6/29 12:18
 **/
@Slf4j
@Service
public class UserDetialsServiceImp implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        /* 定义用户角色 */
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        QueryWrapper<com.example.springsecuritytest.entity.User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        com.example.springsecuritytest.entity.User user = userMapper.selectOne(queryWrapper);

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        log.info("user={}", user);

        /* 返一个具体的用户, 通过BCryptPasswordEncoder对密码进行加密， 添加用户权限  */
        return new User("Eldonk",
                new BCryptPasswordEncoder().encode(user.getPassword()), auths);
    }
}
