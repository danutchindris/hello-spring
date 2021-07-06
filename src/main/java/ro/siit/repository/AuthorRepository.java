package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
