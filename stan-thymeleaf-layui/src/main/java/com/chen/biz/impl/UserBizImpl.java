package com.chen.biz.impl;

import com.chen.biz.UserBiz;
import com.chen.dao.MyUserInfoMapper;
import com.chen.entity.MyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


 /* 请求=》controller=>service(biz)=>dao=>DB
         */
@Service
public class UserBizImpl  implements UserBiz {
    @Autowired
    private MyUserInfoMapper myUserInfoMapper;
    @Override
    public List<MyUserInfo> selectAllUser() {
        return myUserInfoMapper.selectAllUser();
    }

}
