package com.mervorika;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
    private int id;
    @Column(name = "name" , length = 100,nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name =  "publicationYear")
    private LocalDate publicationYear;
    @Column(name = "stock")
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id" , referencedColumnName = "id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    @JoinColumn ( name = "publisher_id" , referencedColumnName = "id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book" ,fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private List<BookBorrowing> borrowList;

    @ManyToMany(mappedBy = "bookList",fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    private List<Category> categoryList;

}
