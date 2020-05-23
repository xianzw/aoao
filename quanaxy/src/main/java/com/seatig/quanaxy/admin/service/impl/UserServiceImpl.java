package com.seatig.quanaxy.admin.service.impl;

import com.seatig.quanaxy.admin.entity.User;
import com.seatig.quanaxy.admin.mapper.UserMapper;
import com.seatig.quanaxy.admin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
