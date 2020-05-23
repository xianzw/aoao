package com.xianzw.aoao.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xianzw.aoao.entity.user.UserRole;
import com.xianzw.aoao.mapper.user.UserRoleMapper;
import com.xianzw.aoao.service.IUserRoleService;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
