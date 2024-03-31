package com.mervorika;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bookBorrowings")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
    private int id;
    @Column(name = "name" , length = 100,nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name =  "borrowingDate")
    private LocalDate borrowingDate;
    @Temporal(TemporalType.DATE)
    @Column(name =  "returnDate")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id" , referencedColumnName = "id")
    private Book book;
}
