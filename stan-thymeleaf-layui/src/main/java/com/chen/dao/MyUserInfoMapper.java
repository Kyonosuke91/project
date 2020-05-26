package com.chen.dao;

import com.chen.entity.MyUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyUserInfoMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(MyUserInfo record);

    int insertSelective(MyUserInfo record);

    MyUserInfo selectByPrimaryKey(Integer userid);

    List<MyUserInfo> selectAllUser();

    int updateByPrimaryKeySelective(MyUserInfo record);

    int updateByPrimaryKey(MyUserInfo record);
}