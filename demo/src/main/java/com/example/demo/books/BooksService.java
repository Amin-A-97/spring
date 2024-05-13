package com.example.demo.books;
public interface BooksService {
    BooksEntity getBookById(Long id);
    BooksEntity saveBook(BooksEntity booksEntity);
    BooksEntity getBookByTitle(String title);

}
