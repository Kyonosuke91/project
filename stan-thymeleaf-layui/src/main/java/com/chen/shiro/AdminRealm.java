package com.chen.shiro;


import com.chen.biz.AdminBiz;
import com.chen.entity.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRealm extends AuthorizingRealm {
    @Autowired
    private AdminBiz adminBiz;
    /**
     *授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权开始了！");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户信息,前提是在认证的时候将用户信息放入到Principal中
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        //权限的字符串需要从数据库中获取
        String perms = admin.getPath();
        simpleAuthorizationInfo.addStringPermission(perms);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证开始了！");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        Admin admin = adminBiz.selectByName(usernamePasswordToken.getUsername());
        if(admin==null){
            return null;
        }
        //Object principal, Object credentials, String realmName
        //第二个参数是密码，数据库中的密码
        String sqlpassword=admin.getPassword();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin,sqlpassword,"");
        return simpleAuthenticationInfo;
    }
}
