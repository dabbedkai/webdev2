package com.webdev2.controller;

import com.webdev2.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/books")
public class BookController {

    private final List<Book> bookList = new ArrayList<>();

    public BookController() {
        // Initial seed data
        bookList.add(new Book(1L, "Clean Code", "Robert C. Martin", 2500.00));
        bookList.add(new Book(2L, "The Pragmatic Programmer", "Andrew Hunt", 2800.00));
        bookList.add(new Book(3L, "Design Patterns", "Erich Gamma", 3200.00));
        bookList.add(new Book(4L, "Refactoring", "Martin Fowler", 2900.00));
    }

    // Task 1 & Task 2:
    @GetMapping
    @ResponseBody
    public List<Book> getAllBooks(@RequestParam(name = "author", required = false) String author) {
        if (author != null && !author.isBlank()) {
            return bookList.stream()
                    .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                    .collect(Collectors.toList());
        }
        return bookList;
    }

    // Task 1 & Task 5:
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> foundBook = bookList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        return foundBook
                .map(book -> ResponseEntity.ok(book))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Task 3:
    @GetMapping("/{id}/view")
    public String getBookDetailView(@PathVariable("id") Long id, Model model) {
        Book book = bookList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("book", book);
        return "book-detail";
    }

    // Task 4 & Task 5:
 @PostMapping
@ResponseStatus(HttpStatus.CREATED) // Satisfies Task 5 requirement
public String createBook(@ModelAttribute Book newBook) {
    newBook.setId((long) (bookList.size() + 1));

    bookList.add(newBook);
    return "redirect:/books";
}

    
}