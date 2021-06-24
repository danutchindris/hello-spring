package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
