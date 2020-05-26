package com.chen.dao;

import com.chen.entity.Admin;
import com.chen.entity.MyUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Admin record);

    int insertSelective(Admin record);

     Admin selectByName(String name);

     List<Admin> selectAllAdmin();

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}
