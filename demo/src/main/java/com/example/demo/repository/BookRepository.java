package com.example.demo.repository;

import com.example.demo.entity.Book;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    public List<Book> findByAuthor(Book author);
    public Book findByLanguage(String language);
    public Book findByGenre(String genre);
    public Book findByPages(int pages);


}
