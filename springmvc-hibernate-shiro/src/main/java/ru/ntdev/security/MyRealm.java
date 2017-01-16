/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.security;



import ru.ntdev.user.entity.RoleEntity;
import ru.ntdev.user.entity.UserEntity;
import java.util.List;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ntdev.user.entity.ResourceItemEntity;
/**
 *
 * @author vminakov
 */

public class MyRealm extends AuthorizingRealm {

    private SessionFactory sessionFactory;
    private PasswordMatcher credentialsMatcher;
    
    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    public MyRealm() {        
        setName("myrealm");
    }        

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        logger.info("User Authoriztion");        
        String userName = pc.getPrimaryPrincipal() + "";
        Session s = sessionFactory.openSession();
        Query q = s.createQuery("SELECT n FROM UserEntity n WHERE n.username = :name").setParameter("name", userName);
        List<UserEntity> l = q.list();
        if (!l.isEmpty()) {
            UserEntity user = l.get(0);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (RoleEntity role : user.getRoles()) {
                info.addRole(role.getCode());
                //HashSet<Permission> permissions = new HashSet<Permission>();
                for (ResourceItemEntity resource : role.getResources()) {
                    Permission p = new WildcardPermission(resource.getType().getCode()+':'+resource.getCode()+":*");                                                                                
                    info.addObjectPermission(p);
                    logger.info("User Authorization:permissions add: ["+p+"]");
                }
                
            }            
            s.close();
            logger.info("User Authorization::"+info);
            return info;
        }
        s.close();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {        
        
        Session s = sessionFactory.openSession();
        at = (UsernamePasswordToken) at;
        logger.info("User Authentication username is "+at.getPrincipal());           
        Query q = s.createQuery("SELECT n FROM UserEntity n where n.username = :name").setParameter("name", at.getPrincipal());
        List<UserEntity> l = q.list();
        if (!l.isEmpty()) {
            UserEntity user = l.get(0);
            s.close();                        
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), getName());
        }
        s.close();
        return null;
    }
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

}
