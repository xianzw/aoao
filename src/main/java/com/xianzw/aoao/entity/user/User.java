package com.xianzw.aoao.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xianzw.aoao.entity.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Getter
@Setter
@TableName("u_user")
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

    //名称
    private String name;

    //用户名
    private String username;

    //密码
    private String password;

    //加密盐
    private String salt;

    //锁定
    private Integer locked = 0;

}
