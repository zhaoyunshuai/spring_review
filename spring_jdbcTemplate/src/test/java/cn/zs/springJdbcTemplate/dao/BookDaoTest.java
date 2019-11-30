package cn.zs.springJdbcTemplate.dao;

import cn.zs.springJdbcTemplate.bo.BookBo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookDaoTest {
    @Autowired
    BookDao bookDao;
    @Autowired
    BookBo book;

    @Test
    public void test() {
        book.setName("西游记");
        book.setPrice(199.99d);
        bookDao.saveBook(book);
    }
    @Test
    public void find(){
        List<BookBo> book = bookDao.findBook(1);
        for (BookBo bookBo : book) {
            System.out.println(bookBo);
        }

    }
}