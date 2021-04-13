package com.wkcto.provider;

import com.wkcto.dao.UserInfoDao;
import com.wkcto.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 梁超
 * @create 2021-04-12 17:22
 */
@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        User user = null;
        if (username != null) {
            userInfo = dao.findByUsername(username);

            if (userInfo != null) {
                List<GrantedAuthority> list = new ArrayList<>();
                //角色必须以ROLE_开头
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + userInfo.getRole());
                list.add(authority);
                //创建UserDetails的实现类User
                user = new User(userInfo.getUsername(), userInfo.getPassword(), list);
            }
        }

        return user;
    }
}
