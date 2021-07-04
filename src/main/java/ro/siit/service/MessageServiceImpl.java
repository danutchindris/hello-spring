package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.domain.Message;
import ro.siit.model.MessageDto;
import ro.siit.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public boolean saveMessage(final MessageDto messageDto) {
        final Message message = new Message();
        message.setEmail(messageDto.getEmail());
        message.setSubject(messageDto.getSubject());
        message.setBody(messageDto.getBody());
        final Message savedMessage = messageRepository.save(message);
        return (savedMessage.getId() != null);
    }

    @Override
    public List<MessageDto> findAll() {
        return messageRepository.findAll().stream()
                .map(m -> new MessageDto(m.getEmail(), m.getSubject(), m.getBody()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateMessage(final Long id, final MessageDto messageDto) {
        messageRepository.findById(id)
                .ifPresent(message -> {
                    message.setEmail(messageDto.getEmail());
                    message.setSubject(messageDto.getSubject());
                    message.setBody(messageDto.getBody());
                    messageRepository.save(message);
                });
        return true; // TODO: this is bad; change it
    }
}
