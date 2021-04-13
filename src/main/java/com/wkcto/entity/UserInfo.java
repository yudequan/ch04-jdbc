package com.wkcto.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 梁超
 * @create 2021-04-12 15:54
 */
//表示当前类是一个实体类，表示数据库中的一个表（表名默认和类名一样）
@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    //角色
    private String role;

}
