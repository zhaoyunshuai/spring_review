package springTransaction.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springTransaction.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContest.xml")
public class AccountServiceImplTest {


    @Autowired
    IAccountService accountService;
    @Test
    public void test(){
        accountService.transfer("rose","jack",100d);
    }
}