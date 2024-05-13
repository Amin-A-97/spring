package com.example.demo.books;
import com.example.demo.exception.ResourceNotFoundException;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping("api/books/findbook/byid/{id}")
    public BooksEntity getBookById(@PathVariable("id") Long id){
        BooksEntity booksFound = booksService.getBookById(id);
        return booksFound;
    }
    @GetMapping("api/books/findbook/bytitle/{title}")
    public BooksEntity getBookByTitle(@PathVariable("title") String title){
        BooksEntity booksFound = booksService.getBookByTitle(title);
        return booksFound;
    }
    @GetMapping("api/books/findbook/")
    public BooksEntity customSearch() throws ResourceNotFoundException {

        return null;
    }
    @PostMapping("api/books/newbook/")
    public BooksEntity saveBook(@RequestBody BooksEntity booksEntity) throws ResourceNotFoundException {
        BooksEntity booksFound = booksService.saveBook(booksEntity);
        return booksFound;
    }
    @GetMapping("/api/auth/signin/sayhello/")
    public String sayHello(){
        return "sayHello";
    }

}
