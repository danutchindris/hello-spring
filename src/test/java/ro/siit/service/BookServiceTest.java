package ro.siit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.siit.domain.Author;
import ro.siit.domain.Book;
import ro.siit.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService = new BookServiceImpl();

    @Test
    void testFindByAuthor() {
        var author = new Author(1L, "Jules Verne");
        when(bookRepository.retrieveBooksByAuthorId(1L)).thenReturn(
                List.of(
                        new Book(7L, "5 saptamani in balon", author, LocalDate.of(1890, 10, 02)),
                        new Book(4L, "Cei trei muschetari", author, LocalDate.of(1878, 05, 12)),
                        new Book(8L, "Dupa douazeci de ani", author, LocalDate.of(1893, 01, 10))
                )
        );

        var books = bookService.findByAuthor(1L);

        Assertions.assertNotNull(books, "The returned list should exist");
        Assertions.assertTrue(3 == books.size(), "The returned list doesn't contain the expected number of elements");
    }
}
