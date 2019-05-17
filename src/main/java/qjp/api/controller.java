package qjp.api;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import qjp.domain.Book;

import java.util.List;

@RestController
public class controller {
    @Autowired
   SqlSessionTemplate sqlSessionTemplate;
    @GetMapping("/v1/get/{num}")
    public Book get(@PathVariable Integer num){
        return sqlSessionTemplate.selectOne("find",num);
    }
    @GetMapping("/v1/getall")
    public List<Book> getall(){
        return sqlSessionTemplate.selectList("getAll");
    }
}

