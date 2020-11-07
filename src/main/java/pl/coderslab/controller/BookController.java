package pl.coderslab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService bookService;

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        logger.info("getAllBooks");
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id) {
        logger.info("bookById");
        return bookService.getBookById(id);
    }

    @PostMapping()
    public void addBookToLibrary(@RequestBody Book book) {
        bookService.addBook(book);
        logger.info("addBookToLibrary");
    }

    @DeleteMapping("/{id}")
    public void deleteBookFromLibrary(@PathVariable Long id) {
        bookService.deleteBook(id);
        logger.info("deleteBookFromLibrary");
    }

    @PutMapping()
    public void updateBookInLibrary(@RequestBody Book book) {
        bookService.updateBook(book);
        logger.info("updateBookInLibrary");
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

}
