package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Void> createBook(@RequestBody Book bookInfo){
        if (bookInfo.getId().toString().length() != 13 && (bookInfo.getPublicationYear() >= 1900 && bookInfo.getPublicationYear() <= 2025) && bookInfo.getPages() > 10) {
            return ResponseEntity.badRequest().build();
        }
        try {
            bookService.createBook(bookInfo);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("/update")
    public  Book updateBook(@RequestBody Book bookInfo){
        return bookService.updateBook(bookInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
