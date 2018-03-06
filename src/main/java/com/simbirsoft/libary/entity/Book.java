package com.simbirsoft.libary.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String cost;

    @Column
    private String isbn;

    @Column
    private Long attachmentId;
}
