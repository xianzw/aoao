package com.xianzw.aoao.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.service.user.IUserService;
import com.xianzw.aoao.utils.ObjectUtil;

/**
 * 自定义Realm
 * @author xianzw
 * @date 2020年5月8日下午4:53:26
 *
 */
@Component
public class CustomRealm extends AuthorizingRealm{

	@Autowired
	IUserService userService;
	

    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		
		//获取用户名
        String username = (String) authenticationToken.getPrincipal();
        
        //根据用户名查找用户
        User user = userService.getUserByUsername(username);
        
        //判断用户是否存在
        if (ObjectUtil.isEmpty(user)) {
            throw new UnknownAccountException("当前登录用户不存在");
        }
		
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        
		return simpleAuthenticationInfo;
	}

}
