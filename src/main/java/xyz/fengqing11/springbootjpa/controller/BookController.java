package xyz.fengqing11.springbootjpa.controller;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fengqing11.springbootjpa.pojo.Book;
import xyz.fengqing11.springbootjpa.service.BookService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/findAll")
    public void findAll() {
        Pageable pageable = PageRequest.of(2, 3);
        Page<Book> page = bookService.getBookByPage(pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总查询数：" + page.getTotalElements());
        System.out.println("查询结果：" + page.getContent());
        System.out.println("当前页数：" + (page.getNumber() + 1));
        System.out.println("当前记录数：" + page.getNumberOfElements());
        System.out.println("每页记录数：" + page.getSize());
    }

    @GetMapping("/search")
    public void search(){

    }

    @GetMapping("/save")
    public void save(){
        Book book = new Book();
        book.setAuthor("按实际嗲");
        book.setName("加速度");
        book.setPrice(23F);
        bookService.addBook(book);
    }
}
