package com.chen.biz.impl;

import com.chen.biz.AdminBiz;
import com.chen.dao.AdminMapper;
import com.chen.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/* 请求=》controller=>service(biz)=>dao=>DB
 */
@Service
public class AdminBizImpl  implements AdminBiz {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin selectByName(String name) {
        return adminMapper.selectByName(name);
    }

}
