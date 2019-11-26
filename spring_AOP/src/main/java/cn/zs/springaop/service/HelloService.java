package cn.zs.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public void sayHello(){
        System.out.println("Hello");
    }
}
