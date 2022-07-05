package com.example.springsecuritytest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName User
 * @Description TODO
 * @Author k2001
 * Date 2022/6/30 11:55
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("user")
public class User {

    /* 用户id */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /* 用户名 */
    private String username;

    /* 密码 */
    private String password;
}
