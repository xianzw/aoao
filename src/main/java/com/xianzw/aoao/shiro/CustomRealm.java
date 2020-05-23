package com.xianzw.aoao.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.service.IUserService;
import com.xianzw.aoao.utils.ObjectUtil;

/**
 * 自定义Realm
 * @author xianzw
 * @date 2020年5月8日下午4:53:26
 *
 */
public class CustomRealm extends AuthorizingRealm{

	@Autowired
	IUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		//获取用户名
        String username = (String) token.getPrincipal();
        
        //根据用户名查找用户
        User user = userService.getUserByUsername(username);
        
        //判断用户是否存在
        if (ObjectUtil.isEmpty(user)) {
            throw new UnknownAccountException("当前登录用户不存在");
        }
		
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        
		return authenticationInfo;
	}

}
