package com.mervorika;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
    private int id;
    @Column(name = "name" , length = 100,nullable = false)
    private String name;
    @Column(name = "description" , length = 300,nullable = false)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "cat2book",
            joinColumns = {@JoinColumn(name = "cat2book_category_id" )},
            inverseJoinColumns = {@JoinColumn(name = "cat2book_book_id")}
    )
    private List<Book> bookList;
}
