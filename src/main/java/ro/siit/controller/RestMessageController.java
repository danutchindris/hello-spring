package ro.siit.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.siit.model.MessageDto;
import ro.siit.service.MessageService;

import javax.validation.Valid;
import java.util.List;

@Api(value = "API for handling user messages")
@RestController
public class RestMessageController {

    @Autowired
    private MessageService messageService;

    @ApiOperation(value = "Endpoint which returns all messages")
    @GetMapping("/messages")
    public List<MessageDto> getAllMessages() {
        return messageService.findAll();
    }

    @PostMapping("/messages")
    public ResponseEntity<String> createMessage(@Valid @RequestBody final MessageDto messageDto) {
        if (messageService.saveMessage(messageDto)) {
            return ResponseEntity.ok("The message was saved b0$$");
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("The message was not saved pleb");
    }

    @PutMapping("/messages/{messageId}")
    public ResponseEntity<String> updateMessage(@PathVariable("messageId") final Long messageId, @Valid @RequestBody final MessageDto messageDto) {
        messageService.updateMessage(messageId, messageDto);
        return ResponseEntity.ok("The message was saved b0$$");
    }
}
