package com.simbirsoft.libary.service;

import com.simbirsoft.libary.entity.Book;
import com.simbirsoft.libary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BookService {
    @Autowired private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return book.get();
        }
        throw new EntityNotFoundException();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Long id, Book book) {
        Optional<Book> bookFromDb = bookRepository.findById(id);
        if (bookFromDb.isPresent()) {
            Book oldBook = bookFromDb.get();
            oldBook.setAuthor(book.getAuthor());
            oldBook.setCost(book.getCost());
            oldBook.setIsbn(book.getIsbn());
            oldBook.setName(book.getName());
            oldBook.setAttachmentId(book.getAttachmentId());
            return bookRepository.save(oldBook);
        }
        throw new EntityNotFoundException();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
