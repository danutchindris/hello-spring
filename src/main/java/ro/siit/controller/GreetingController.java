package ro.siit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.siit.model.Person;

@Controller
public class GreetingController {
    // echivalent cu: @GetMapping("/greeting")
    // echivalent cu: @RequestMapping("/greeting")
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public String showGreetingPage(final Model model) {
        model.addAttribute("person", new Person());
        return "greeting-form";
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/greet")
    @PostMapping("/greet")
    public String displayGreeting(final Model model, final Person p) {
        model.addAttribute("name", p.getName());
        return "greeting-result";
    }
}
