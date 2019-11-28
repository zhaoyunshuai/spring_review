package cn.zs.springAspectJAnnotation.service.impl;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {
    public void save() {
        System.out.println("没有实现接口：信息被保存了........");
    }

    public int find() {
        System.out.println("没有接口实现：信息被找到了......");
        int a =1/0;
        return 10086;
    }
}
