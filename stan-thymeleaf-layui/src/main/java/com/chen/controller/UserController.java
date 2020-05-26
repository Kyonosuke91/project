package com.chen.controller;

import com.chen.biz.UserBiz;
import com.chen.entity.LayUITable;
import com.chen.entity.MyUserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserBiz userBizImpl;
    @RequestMapping("/toShowUserpage")
    public String toShowUserpage(Model model){
        List<MyUserInfo> userInfoList = userBizImpl.selectAllUser();
        model.addAttribute("userInfoList",userInfoList);
        model.addAttribute("name","STAN");
        return "showUser";
    }

    @RequestMapping("/showUserLayui")
    @ResponseBody
    public LayUITable showUserLayui(int page,int limit){
        //开始分页,第一个参数是当前第几页，第二个参数是一页显示多少行
        PageHelper.startPage(page,limit);
//开始查询
        List<MyUserInfo> userInfoList = userBizImpl.selectAllUser();
//结束分页,pageInfo封装了分页之后所有数据
        PageInfo<MyUserInfo> pageInfo = new PageInfo(userInfoList);
        LayUITable layUITable = new LayUITable();
        layUITable.setCode(0);
        layUITable.setMsg("返回消息");
//设置分页之后的返回值
        layUITable.setCount(pageInfo.getTotal());
        layUITable.setData(pageInfo.getList());
        return layUITable;
    }

}