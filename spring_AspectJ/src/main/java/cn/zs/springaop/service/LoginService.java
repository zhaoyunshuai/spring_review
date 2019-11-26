package cn.zs.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public void login(){
        System.out.println("用户登录了");
    }
}
