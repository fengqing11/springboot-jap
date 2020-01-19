package xyz.fengqing11.springbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.fengqing11.springbootjpa.dao.BookDao;
import xyz.fengqing11.springbootjpa.pojo.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDao;
    public void addBook(Book book){
        bookDao.save(book);
    }

    public Page<Book> getBookByPage(Pageable pageable){
        return bookDao.findAll(pageable);
    }

    public List<Book> getBooksByAuthorStartingWith(String author){
        return bookDao.getBooksByAuthorStartingWith(author);
    }

    public List<Book> getBooksByPriceGreaterThan(Float price){
        return bookDao.getBooksByPriceGreaterThan(price);
    }

    public Book getMaxIdBook(){
        return bookDao.getMaxIdBook();
    }

    public List<Book> getBookByIdAndAuthor(String author,Integer id){
        return bookDao.getBookByIdAndAuthor(author,id);
    }

    public List<Book> getBooksByIdAndName(String name,Integer id){
        return bookDao.getBookByIdAndAuthor(name,id);
    }
}
