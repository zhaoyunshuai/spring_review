package cn.zs.springTransaction.dao.impl;

import cn.zs.springTransaction.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void in(String name, Double money) {
        String sql="update t_account set money = money+ ? where name = ? ";
    jdbcTemplate.update(sql,money,name);
    }

    public void out(String name, Double money) {
        String sql="update t_account set money = money- ? where name = ? ";
        jdbcTemplate.update(sql,money,name);
    }
}
