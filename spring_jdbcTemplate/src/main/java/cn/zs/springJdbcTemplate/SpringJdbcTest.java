package cn.zs.springJdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringJdbcTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate2;

    @Test
    public void test01() {
        jdbcTemplate.execute("create table test002(id int,name varchar(20))");
    }


    @Test
    public void c3p0Test() {
        jdbcTemplate2.execute("insert into test003 values  (2,'LISI')");
    }
}
