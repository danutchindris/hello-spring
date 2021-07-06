package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.domain.Author;
import ro.siit.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(Author author);
}
