package ro.siit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        var elements = List.of("abc");
        elements.get(1);
        return "test";
    }
}
