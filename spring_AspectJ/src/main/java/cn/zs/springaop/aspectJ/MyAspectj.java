package cn.zs.springaop.aspectJ;

import org.springframework.stereotype.Component;

@Component
public class MyAspectj {
    public void before(){
        System.out.println("我是前置通知，被执行了...");
    }

    public void after(){
        System.out.println("我是后置通知");
    }
}
