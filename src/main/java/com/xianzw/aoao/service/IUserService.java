package com.xianzw.aoao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xianzw.aoao.common.ServiceException;
import com.xianzw.aoao.entity.user.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xianzw
 * @since 2020-05-08
 */
public interface IUserService extends IService<User> {

	/**
	 * 根据id获取user
	 * @param id
	 * @return
	 * @throws ServiceException 
	 */
	User getUserById(String id) throws ServiceException;

	/**
	 * 根据用户名获取user
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);

	/**
	 * 用户注册
	 * @param convert
	 * @return
	 */
	User signup(User user);

}
