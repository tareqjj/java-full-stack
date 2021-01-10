package com.springdataone.mvc.services;

import com.springdataone.mvc.models.Book;
import com.springdataone.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // update a book
    public Book updateBook(long id, String title, String desc, String lang, Integer numOfPages) {
        Book bookToUpdate = findBook(id);
        if (bookToUpdate != null) {
            bookToUpdate.setTitle(title);
            bookToUpdate.setDescription(desc);
            bookToUpdate.setLanguage(lang);
            bookToUpdate.setNumberOfPages(numOfPages);
            return bookRepository.save(bookToUpdate);
        } else {
            return null;
        }
    }
    // delete Book
    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }
}
