package cn.zs.springJdbcTemplate.bo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BookBo {

    private int id;
    private String name;
    private double price;
}
