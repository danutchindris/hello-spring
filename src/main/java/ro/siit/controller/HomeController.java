package ro.siit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    // clasa este considerata un "Spring bean"
    // containerul Spring face managementul obiectelor de tip HomeController

    @GetMapping({"/", "/home", "/index"})
    public String showHomePage(final Model model, @RequestParam("fname") final String firstName,
                               @RequestParam(value = "lname", required = false) final String lastName) {
        model.addAttribute("first_name", firstName);
        model.addAttribute("last_name", lastName);
        return "home"; // acesta este un nume de "view"
    }
}
// Spring MVC: Model-View-Controller (design pattern)
