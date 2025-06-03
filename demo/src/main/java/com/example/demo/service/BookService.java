package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor

public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(Book bookInfo){
        Book book = new Book();
        book.setAuthor(bookInfo.getAuthor());
        book.setGenre(bookInfo.getGenre());
        book.setIsbn(bookInfo.getIsbn());
        book.setLanguage(bookInfo.getLanguage());
        book.setPages(bookInfo.getPages());
        book.setPublicationYear(bookInfo.getPublicationYear());
        book.setTitle(bookInfo.getTitle());
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }





    /* public List<Book> getBooksByAuthor(String author){
        List<Book> booksList = new ArrayList<>();
        List<Book> optionalBook = bookRepository.findByAuthor(author);
        if(optionalBook.isEmpty()){
            throw new RuntimeException("No books found for author: " + author);
        }
        List<Book> books = bookRepository.findByAuthor(optionalBook.get());

    }*/







}
