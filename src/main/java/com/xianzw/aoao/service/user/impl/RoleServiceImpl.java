package com.xianzw.aoao.service.user.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xianzw.aoao.entity.user.Role;
import com.xianzw.aoao.mapper.user.RoleMapper;
import com.xianzw.aoao.service.user.IRoleService;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
