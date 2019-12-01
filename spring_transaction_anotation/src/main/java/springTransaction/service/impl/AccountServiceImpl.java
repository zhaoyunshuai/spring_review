package springTransaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springTransaction.dao.IAccountDao;
import springTransaction.service.IAccountService;

import static org.springframework.transaction.annotation.Isolation.DEFAULT;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountDao accountDao;

    @Transactional(isolation = DEFAULT, propagation = Propagation.REQUIRED)
    public void transfer(String outUsername, String inUsername, Double money) {
        accountDao.out(outUsername, money);
        //此处打开，可以直接验证事务是否生效。
       // int i = 1 / 0;
        accountDao.in(inUsername, money);
    }
}
