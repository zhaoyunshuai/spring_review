package cn.zs.springaop.service;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {
    public void save() {
        System.out.println("客户保存了....");
    }

    public int find() {
        System.out.println("客户查询数量了....");
        return 10;
    }
}
