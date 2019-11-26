package cn.zs.springaop.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {
    /*前置通知：
     * 实现权限的控制。（即权限不足时抛出异常，）、记录方法调用信息日志。
     *
     * */
    public void qianzhi() {
        String loginName = "Rose";
        System.out.println(loginName);
    }
}
