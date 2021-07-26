package ro.siit.service;

import ro.siit.model.MessageDto;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    boolean saveMessage(MessageDto messageDto);

    List<MessageDto> findAll();

    boolean updateMessage(Long id, MessageDto messageDto);

    Optional<MessageDto> findByEmail(String email);
}
