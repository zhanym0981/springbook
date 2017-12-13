package com.yzhan.bookapp.repository;

import com.yzhan.bookapp.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
