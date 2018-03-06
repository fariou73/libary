package com.simbirsoft.libary.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String docName;

    @Column
    private Long size;

    @Column
    private String type;

    @Column
    @Lob
    private byte[] file;
}
