package com.example.springsecuritytest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author k2001
 * Date 2022/6/29 11:20
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    /**
     * 自定义配置账号密码
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    /**
     * 自定义相关配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()    // 自定义登录页面
                .loginPage("/login.html")    // 登录页面的设置
                .loginProcessingUrl("/user/login")   //登录访问路径, springSecurity帮忙写的controller
                .defaultSuccessUrl("/test/demo")     // 登录成功之后跳转的路径
                .and().authorizeRequests()
                .antMatchers("/", "/user/login", "/login.html").permitAll()    // 不拦截的路径
                .anyRequest().authenticated()
                .and().csrf().disable();    // 关闭csrf防护
    }

    //    /**
//     * 设置忽略拦截的路径
//     *
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/test/**");
//    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}
