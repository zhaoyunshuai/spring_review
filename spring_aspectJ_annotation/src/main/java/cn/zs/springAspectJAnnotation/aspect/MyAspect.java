package cn.zs.springAspectJAnnotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
    @Before("execution(* cn.zs.springAspectJAnnotation.service.impl.CustomerServiceImpl.*(..))||execution(* cn.zs.springAspectJAnnotation.service.impl.ProductService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知，我会在方法执行之前去执行.....");
    }
}
