package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.siit.domain.Author;
import ro.siit.domain.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(Author author);

    @Query("select b from Book b inner join b.author a where a.id = :aId") // JPQL expression (NOT SQL)
    List<Book> retrieveBooksByAuthorId(@Param("aId") Long authorId);
}
