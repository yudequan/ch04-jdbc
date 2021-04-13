package com.wkcto.init;

import com.wkcto.dao.UserInfoDao;
import com.wkcto.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 梁超
 * @create 2021-04-12 17:09
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Component
public class JdbcInit {
    private final UserInfoDao dao;

    @PostConstruct
    public void init(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        UserInfo u;
        if (null == dao.findByUsername("lc")) {
            u = new UserInfo();
            u.setUsername("lc");
            u.setPassword(encoder.encode("l11"));
            u.setRole("normal");
            dao.save(u);
        }

        if (null == dao.findByUsername("xx")) {
            u = new UserInfo();
            u.setUsername("xx");
            u.setPassword(encoder.encode("222"));
            u.setRole("admin");
            dao.save(u);
        }
    }
}
