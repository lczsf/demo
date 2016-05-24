package com.company.common;

import com.company.model.TRole;
import com.company.model.TUser;
import com.company.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/5/19.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = null;
        try {

            // 搜索数据库以匹配用户登录名.
            // 我们可以通过dao使用JDBC来访问数据库
            TUser tUser = userService.queryByUserName(s);

            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correct
            // role type

            user = new User(tUser.getName(), tUser.getPassword()
                    .toLowerCase(), true, true, true, true,
                    getAuthorities(userService.queryRolesByUserName(s)));

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }

    /**
     * 获得访问角色权限
     *
     * @param tRoles
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(List<TRole> tRoles) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        for (TRole tRole : tRoles) {
            authList.add(new SimpleGrantedAuthority(tRole.getRole()));
        }
        return authList;
    }
}
