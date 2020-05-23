package com.xianzw.aoao.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.mapper.user.UserMapper;
import com.xianzw.aoao.service.IUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
