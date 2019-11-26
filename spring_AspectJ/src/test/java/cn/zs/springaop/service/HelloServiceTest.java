package cn.zs.springaop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @Autowired
    LoginService loginService;

    @Test
    public void sayHello() {
        helloService.sayHello();

        helloService.printString();

        loginService.login();

        loginService.afterReturningTest();

        loginService.aroundTest();
      /*
      * 此处需要注意：被最终通知的方法需要在被异常通知的方法之前执行，
      * 不然发生异常以后是执行不到这个方法的
      *如果是对同一个方法进行的异常通知和最终通知则不会发生这种情况，最终通知无论发生什么情况都会被执行。
      * */
        loginService.afterTest();

        loginService.afterThrowingTest();


    }
}