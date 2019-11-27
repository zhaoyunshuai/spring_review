package cn.zs.springAspectJAnnotation.service.impl;

import cn.zs.springAspectJAnnotation.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProductServiceTest {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;

    @Test
    public void test(){
        customerService.save();
        int i = customerService.find();
        System.out.println(i);

        productService.save();
        int i1 = productService.find();
        System.out.println(i1);
    }

}