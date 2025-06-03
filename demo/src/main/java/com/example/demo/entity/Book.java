package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "publication_year", nullable = false)
    private Integer publicationYear;

    @Column(name = "language", nullable = true)
    private String language;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "genre", nullable = false)
    private String genre;

}
