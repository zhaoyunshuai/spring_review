package cn.zs.springAspectJAnnotation.aspect;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import sun.awt.SunHints;


@Aspect
@Component
public class MyAspect {
    @Before("execution(* cn.zs.springAspectJAnnotation.service.impl.CustomerServiceImpl.*(..))||execution(* cn.zs.springAspectJAnnotation.service.impl.ProductService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("我是前置通知，我会在方法执行之前去执行.....");
    }

    @AfterReturning(value = "bean(*Service)", returning = "value")
    public void afterReturning(JoinPoint joinPoint, Object value) {
        System.out.println("----我是后置通知----");

    }

    @Around("bean(*Service)")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知，环绕在方法之前QQQQQ");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知，环绕在方法之后HHHHH");
        return proceed;
    }
    @After("bean(*Service)")
    public void after(JoinPoint joinPoint){
        System.out.println("我是最终通知0101010");
    }
@AfterThrowing(value = "bean(*Service)",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        System.out.println("异常通知，也叫做抛出通知"+ e.getMessage());

    }
}
