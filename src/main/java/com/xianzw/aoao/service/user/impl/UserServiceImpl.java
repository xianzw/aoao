package com.xianzw.aoao.service.user.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xianzw.aoao.common.ServiceException;
import com.xianzw.aoao.config.shiro.ShiroUtil;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.mapper.user.UserMapper;
import com.xianzw.aoao.service.user.IUserService;

import cn.hutool.core.util.ObjectUtil;

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

	@Override
	@Transactional(readOnly = true)
	public User getUserById(String id) throws ServiceException {
		if(ObjectUtil.isEmpty(id)) {
			throw new ServiceException("30001", "id不能为空");
		}
		return getById(id);
	}

	/**
	 * 根据用户名获取user
	 */
	@Override
	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
		queryWrapper.eq("username", username);
		return getOne(queryWrapper);
	}

	/**
	 * 用户注册
	 */
	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,noRollbackFor = RuntimeException.class)
	public User signup(User user) {
		//生成盐
        String salt = ShiroUtil.generateSalt();
        //保存盐用于解密
        user.setSalt(salt);
        //加密后密码赋值
        user.setPassword(ShiroUtil.generatePwdEncrypt(user.getPassword(), salt));
        //创建时间
        user.setCreateDate(LocalDateTime.now());
		//保存
        save(user);
		return user;
	}

}
