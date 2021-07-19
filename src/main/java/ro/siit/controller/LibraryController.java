package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.siit.model.BookDto;
import ro.siit.service.AuthorService;
import ro.siit.service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/authors")
    public String retrieveAuthors(final Model model) {
        model.addAttribute("authors", authorService.findAll(3, 3));
        return "all-authors";
    }

    @GetMapping("/authors/books")
    public @ResponseBody
    List<BookDto> retrieveBooks(@RequestParam("authorId") final Long authorId) {
        return bookService.findByAuthor(authorId);
    }

    @GetMapping("/books/{date}")
    public @ResponseBody
    List<BookDto> retrieveBooksByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        return new ArrayList<>();
    }
}
