package com.xianzw.aoao.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xianzw.aoao.config.jwt.JwtToken;
import com.xianzw.aoao.config.jwt.JwtUtil;
import com.xianzw.aoao.config.redis.JedisUtil;
import com.xianzw.aoao.entity.user.User;
import com.xianzw.aoao.model.constant.Constant;
import com.xianzw.aoao.service.IUserService;
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
        return authenticationToken instanceof JwtToken;
    }
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		
		//获取用户名
        String token = (String) authenticationToken.getPrincipal();
        
        //根据用户名查找用户
        User user = userService.getUserByUsername("");
        
        //判断用户是否存在
        if (ObjectUtil.isEmpty(user)) {
            throw new UnknownAccountException("当前登录用户不存在");
        }
		
        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
//        if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
//            // 获取RefreshToken的时间戳
//            String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
//            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
//            if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
//                return new SimpleAuthenticationInfo(token, token, "userRealm");
//            }
//        }        
		return null;
	}

}
