package cn.zs.springaop.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {
    /*前置通知：
     * 实现权限的控制。（即权限不足时抛出异常，）、记录方法调用信息日志。
     *
     * */
    public void before(JoinPoint joinPoint) {
        String loginName = "Rose";
        System.out.println("方法名称：" + joinPoint.getSignature().getName());
        System.out.println("目标对象" + joinPoint.getTarget().getClass().getName());
        System.out.println("代理对象" + joinPoint.getThis().getClass().getName());
        //此处可以用来拦截方法，如果方法名等于login就会进行校验
        if (joinPoint.getSignature().getName().equals("login")) {
            //如果用户名不等于admin，那么就会报出异常，拦截用户的登录。
            if (!loginName.equals("admin")) {
                throw new RuntimeException("您没有权限执行方法：" + joinPoint.getSignature().getName() + "，类型为：" + joinPoint.getTarget().getClass().getName());
            }
        }
    }
}
