package ro.siit.service;

import ro.siit.model.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> findByAuthor(Long authorId);
}
