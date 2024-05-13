package com.example.demo.books;
import com.example.demo.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
@Service
public class BooksCls implements BooksService {
    @Autowired
    public BooksCls(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    BooksRepository booksRepository;
    @Override
    public BooksEntity getBookById(Long id) {
        BooksEntity booksFound = booksRepository.findById(id).orElseThrow(
                () ->  new ResourceNotFoundException("Book With This "+id + " NotFound!")
        );
        return booksFound;
    }
    @Override
    public BooksEntity saveBook(BooksEntity booksEntity) {
        BooksEntity booksSaved = booksRepository.save(booksEntity);
        return booksSaved;
    }
    @Override
    public BooksEntity getBookByTitle(String title) {
        BooksEntity booksFound = booksRepository.findByTitle(title).orElseThrow(
                () ->  new ResourceNotFoundException("Book With This "+ title + " NotFound!")
        );
        return booksFound;
    }


}
