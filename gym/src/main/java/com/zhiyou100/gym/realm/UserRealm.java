package com.zhiyou100.gym.realm;


import com.zhiyou100.gym.pojo.Role;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {

		SimpleAuthorizationInfo info  = new SimpleAuthorizationInfo();
		User user = (User)collection.getPrimaryPrincipal();
		for(Role role : user.getRoles()){
			info.addRole(role.getRoName());
		}


		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account = (String)token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		User user = userService.findByUAccount(account);
		if (user == null) {
			throw new UnknownAccountException("账号不存在");
		}
		if (!password.equals (user.getUsPassword())) {
			throw new IncorrectCredentialsException("密码错误");
		}
		return new SimpleAuthenticationInfo(user,password,getName());
	}

}
