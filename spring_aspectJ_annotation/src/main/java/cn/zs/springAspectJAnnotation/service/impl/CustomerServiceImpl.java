package cn.zs.springAspectJAnnotation.service.impl;

import cn.zs.springAspectJAnnotation.service.CustomerService;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    public void save() {
        System.out.println("信息被保存了.....");
    }

    public int find() {
        System.out.println("信息被查询到了...........");
        return 10010;
    }
}
