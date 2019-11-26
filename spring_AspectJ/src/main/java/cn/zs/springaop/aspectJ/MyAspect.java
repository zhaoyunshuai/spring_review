package cn.zs.springaop.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {
    /*前置通知：
     * 实现权限的控制。（即权限不足时抛出异常，）、记录方法调用信息日志。
     *
     * */
    public void before(JoinPoint joinPoint) {
        String loginName = "admin";
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

    /**
     * 应用场景：与业务相关的比如网上营业厅查询余额，自动下发短信
     * 后置通知：在目标方法执行之后，进行方法的争强
     *
     * @param joinPoint   连接点对象（方法的包装对象：方法，参数，目标对象）
     * @param returnValue 目标方法执行后返回的值。参数名需要在配置文件中进行配置。
     */
    public void afterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("-++++++++-后置通知-当前下发短信的方法-尊敬的用户，您调用的方法返回余额为：" + returnValue);
    }

    /**
     * 应用场景：日志，缓存，权限，性能监控，事务管理
     * 环绕通知，在目标方法执行的前后，可以进行增强。
     *
     * @param proceedingJoinPoint 可以执行的连接点对象， 可以通过调用proceed方法来执行目标对象方法
     * @return
     * @throws Throwable 执行proceed方法时必须要抛出的异常
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("----开启了事务----");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("----提交了事务----");
        return proceed;//目标对象的执行结果。
    }

    /**
     * 作用：目标对象发生异常，通知执行。记录异常日志，通知管理员（短信，邮件）
     * 只有目标方法发生异常时，才会进行执行。
     * @param joinPoint 静态连接点
     * @param e 目标对象抛出的异常，
     */
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("目标方法：" + joinPoint.getTarget().getClass().getName() + " 的方法：" +
                joinPoint.getSignature().getName()
                + "  抛出了异常：" + e.getMessage());
//目标方法：cn.zs.springaop.service.LoginService 的方法：cn.zs.springaop.service.LoginService$$EnhancerBySpringCGLIB$$50eb61e  抛出了异常：/ by zero
    }


    public void after(JoinPoint joinPoint){
        System.out.println("目标对象："+joinPoint.getTarget().getClass().getName() +" 的方法："+joinPoint.getSignature().getName() +"  最终被执行了");

    }
}
