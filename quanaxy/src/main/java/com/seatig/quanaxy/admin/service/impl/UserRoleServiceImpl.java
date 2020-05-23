package com.seatig.quanaxy.admin.service.impl;

import com.seatig.quanaxy.admin.entity.UserRole;
import com.seatig.quanaxy.admin.mapper.UserRoleMapper;
import com.seatig.quanaxy.admin.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
