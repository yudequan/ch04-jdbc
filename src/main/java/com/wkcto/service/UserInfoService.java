package com.wkcto.service;

import com.wkcto.entity.UserInfo;

/**
 * @author 梁超
 * @create 2021-04-12 16:04
 */
public interface UserInfoService {
    UserInfo findUserInfo(String username);
}
