package cn.zs.springaop.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimeLogInterceptor implements MethodInterceptor {
	 
	
	  
	//日志记录器
private static Logger LOGGER = LoggerFactory.getLogger(TimeLogInterceptor.class);

	

	//invocation:代理对象的包装类,获取 代理对象,目标对象,目标方法等信息
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//方法开始前
		long beforeTime = System.currentTimeMillis();
		
		
		//调用目标对象原来的方法,并返回结果
		Object proceed = invocation.proceed();//相当于 method.invoke();
		
		
		//方法结束后
		long afterTime = System.currentTimeMillis();
		
		
		//计算运行时间
		 long runTime = afterTime - beforeTime;
		 
		 System.out.println(invocation.getThis().getClass().getName()+"类的"+invocation.getMethod().getName()+"方法运行了:"+runTime);
		 
		 LOGGER.info(invocation.getThis().getClass().getName()+"类的"+invocation.getMethod().getName()+"方法运行了:"+runTime+"毫秒");

		 
		return proceed;
	}

}