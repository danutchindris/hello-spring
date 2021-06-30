package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String e); // JPA o implementeaza pentru noi "by convention"
    // JPA genereaza un query de genul: select u from users u where u.email = :email
}
