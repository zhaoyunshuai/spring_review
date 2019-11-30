package cn.zs.springJdbcTemplate.dao;

import cn.zs.springJdbcTemplate.bo.BookBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate2;

    public void saveBook(BookBo book) {
        String sql ="insert into  book values(null,?,?)";
        jdbcTemplate2.update(sql,book.getName(),book.getPrice());

    }

    public List<BookBo> findBook(int id){
        String sql ="select * from book where id =?";
        List<BookBo> book = jdbcTemplate2.query(sql, BeanPropertyRowMapper.newInstance(BookBo.class), id);
        return book;
    }
}
