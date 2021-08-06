package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.domain.Book;
import ro.siit.model.BookDto;
import ro.siit.repository.BookRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public List<BookDto> findByAuthor(final Long authorId) {
        final List<Book> books = bookRepository.retrieveBooksByAuthorId(authorId);
        return books.stream()
                .map(b -> new BookDto(b.getId(), b.getTitle()))
                .collect(Collectors.toList());
    }
}
