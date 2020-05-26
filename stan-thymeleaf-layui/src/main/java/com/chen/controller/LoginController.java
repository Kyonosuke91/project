package com.chen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/toShowUserLayui")
    public String toShowUserLayui() {

        return "showUserLayui";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        System.out.println(username + password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //AuthenticationToken token
        //subject.login(token);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            model.addAttribute("message", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message", "密码错误");
            return "login";
        }

        return "showUserLayui";
    }
}