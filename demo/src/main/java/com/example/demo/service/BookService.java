package com.example.demo.service;


import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book bookInfo){
        Optional<Book> book = bookRepository.findById(bookInfo.getId());
        if(book.isPresent()){
            Book bookToUpdate = book.get();
            bookToUpdate.setLanguage(bookInfo.getLanguage());
            bookToUpdate.setTitle(bookInfo.getTitle());
            return bookRepository.save(bookToUpdate);
        } else {
            return null;
        }
    }









}
