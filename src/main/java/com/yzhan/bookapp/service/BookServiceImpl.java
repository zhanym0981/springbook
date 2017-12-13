package com.yzhan.bookapp.service;

import com.yzhan.bookapp.domain.Book;
import com.yzhan.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Service("bookService")
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Autowired
    public void setContactRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public Page<Book> findAllByPage(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
