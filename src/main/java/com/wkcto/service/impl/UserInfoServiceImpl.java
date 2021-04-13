package com.wkcto.service.impl;

import com.wkcto.dao.UserInfoDao;
import com.wkcto.entity.UserInfo;
import com.wkcto.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 梁超
 * @create 2021-04-12 16:05
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoDao dao;
    @Override
    public UserInfo findUserInfo(String username) {
        UserInfo userinfo = dao.findByUsername(username);
        return userinfo;
    }
}