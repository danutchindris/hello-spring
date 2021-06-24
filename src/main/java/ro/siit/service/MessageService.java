package ro.siit.service;

import ro.siit.model.MessageDto;

import java.util.List;

public interface MessageService {

    boolean saveMessage(MessageDto messageDto);

    List<MessageDto> findAll();
}
