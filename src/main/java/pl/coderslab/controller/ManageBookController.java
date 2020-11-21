package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.add(book);
        return "redirect:all";
    }

    @GetMapping("/edit")
    public String editBookForm(@RequestParam long id, Model model) {
        Optional<Book> book = bookService.get(id);
        book.ifPresent(b -> model.addAttribute("book", b));
        return "books/edit";
    }

    @PostMapping("/edit")
    public String editBook(Book book) {
        bookService.update(book);
        return "redirect:all";
    }

    @RequestMapping("/delete")
    public String deleteBook(@RequestParam long id) {
        bookService.delete(id);
        return "redirect:all";
    }

    @RequestMapping("/get")
    public String getParticularBook(@RequestParam long id, Model model) {
        Optional<Book> book = bookService.get(id);
        book.ifPresent(b -> model.addAttribute("book", b));
        return "books/oneBook";
    }

}
