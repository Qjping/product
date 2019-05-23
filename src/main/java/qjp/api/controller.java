package qjp.api;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import qjp.domain.Book;

import java.util.List;

@RestController
public class controller {
    @Autowired
   SqlSessionTemplate sqlSessionTemplate;
    @GetMapping("/v1/get/{id}")
    public Book get(@PathVariable Integer id){
        return sqlSessionTemplate.selectOne("find",id);
    }
    @GetMapping("/v1/get/all")
    public List<Book> getall(){
        return sqlSessionTemplate.selectList("getAll");
    }
    @PostMapping("/v1/update")
    public Book update(@RequestBody Book book){
        sqlSessionTemplate.update("update",book);
        return sqlSessionTemplate.selectOne("find",book.getId());
    }
}

