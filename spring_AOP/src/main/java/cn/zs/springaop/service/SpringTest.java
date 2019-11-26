package cn.zs.springaop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//springjunit集成测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	//注入要测试bean
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ProductService productService;
	
	//测试
	@Test
	public void test(){
		//基于接口
		customerService.save();
		customerService.find();
		//基于类的
		productService.save();
		productService.find();
	}

}