package com.chen.biz;

import com.chen.entity.Admin;

import java.util.List;

public interface AdminBiz {

    Admin selectByName(String username);
}
