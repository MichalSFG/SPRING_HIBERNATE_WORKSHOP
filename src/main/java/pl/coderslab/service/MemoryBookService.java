package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoryBookService implements BookService {
    private List<Book> books;
    private static Long nextId = 4L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glową. Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.of(getBookById(id));
    }

    @Override
    public void add(Book book) {
        addBook(book);
    }

    @Override
    public void delete(Long id) {
        deleteBook(id);
    }

    @Override
    public void update(Book book) {
        updateBook(book);
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public void updateBook(Book book) {
        for (Book b : books) {
            if (b.getId().equals(book.getId())) {
                b.setIsbn(book.getIsbn());
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setType(book.getType());
            }
        }
    }
}
