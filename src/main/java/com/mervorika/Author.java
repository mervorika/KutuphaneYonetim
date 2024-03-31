package com.mervorika;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
    private int id;
    @Column(name = "name" , length = 100,nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name =  "birthDate")
    private LocalDate birthDate;
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY , cascade = CascadeType.REMOVE )
    private List<Book> bookList;
}
