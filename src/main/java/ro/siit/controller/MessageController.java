package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.siit.model.MessageDto;
import ro.siit.service.MessageService;

import javax.validation.Valid;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ModelAndView showMessageForm() {
        final ModelAndView mav = new ModelAndView();
        mav.setViewName("message-form");
        mav.addObject("msg", new MessageDto());
        return mav;
    }

    @PostMapping
    public String processForm(@Valid @ModelAttribute("msg") final MessageDto messageDto, final BindingResult bindingResult,
                              final Model model) {
        if (bindingResult.hasErrors()) {
            return "message-form";
        } else {
            messageService.saveMessage(messageDto);
            return "message-received";
        }
    }

    @GetMapping("/all")
    public String retrieveAllMessages(final Model model) {
        model.addAttribute("messages", messageService.findAll());
        return "all-messages";
    }
}
