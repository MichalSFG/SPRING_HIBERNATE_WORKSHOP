package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Book> getAllBooks() {
        logger.info("getAllBooks");
        return service.getBooks();
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id) {
        logger.info("bookById");
        Optional<Book> book = service.get(id);
        return book.orElse(null);
    }

    @PostMapping()
    public void addBookToLibrary(@RequestBody Book book) {
        service.add(book);
        logger.info("addBookToLibrary");
    }

    @DeleteMapping("/{id}")
    public void deleteBookFromLibrary(@PathVariable Long id) {
        service.delete(id);
        logger.info("deleteBookFromLibrary");
    }

    @PutMapping()
    public void updateBookInLibrary(@RequestBody Book book) {
        service.update(book);
        logger.info("updateBookInLibrary");
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

}
