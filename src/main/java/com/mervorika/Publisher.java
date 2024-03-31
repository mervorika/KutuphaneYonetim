package com.mervorika;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "serial")
    private int id;
    @Column(name = "name" , length = 100,nullable = false)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name =  "establishmentYear")
    private LocalDate establishmentYear;
    @Column(name = "address" , length = 300,nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher" , fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private List<Book> bookList;

}
