package cn.zs.springTransaction.service.impl;

import cn.zs.springTransaction.dao.IAccountDao;
import cn.zs.springTransaction.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountDao accountDao;

    public void transfer(String outUsername, String inUsername, Double money) {
        accountDao.out(outUsername, money);
       // int i = 1 / 0;
        accountDao.in(inUsername, money);
    }
}
