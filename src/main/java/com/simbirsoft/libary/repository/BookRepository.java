package com.simbirsoft.libary.repository;

import com.simbirsoft.libary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
