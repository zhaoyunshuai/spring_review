package cn.zs.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public void login() {
        System.out.println("用户登录了");
    }


    public String afterReturningTest() {
        return "100元";
    }

    public void aroundTest() {
        System.out.println("被环绕通知增强的方法........");
    }

    public void afterThrowingTest(){
        System.out.println("异常通知增强的方法......");
        //此处故意制造异常，用于验证异常通知。
        int id =1/0;
    }

    public void afterTest(){
        System.out.println("最终通知增强此方法...........");
    }
}
