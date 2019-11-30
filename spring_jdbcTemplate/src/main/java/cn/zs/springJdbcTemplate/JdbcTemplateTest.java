package cn.zs.springJdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateTest {
    @Test
    public void creatTable(){
        DriverManagerDataSource dc = new DriverManagerDataSource();
        dc.setDriverClassName("com.mysql.jdbc.Driver");
        //注意此处需要三个斜杠，应该是和转译有关系。
        dc.setUrl("jdbc:mysql:///springjdbctemplate");
        dc.setUsername("root");
        dc.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dc);
        jdbcTemplate.execute("create table test001(id int,name varchar(20))");
    }
}
