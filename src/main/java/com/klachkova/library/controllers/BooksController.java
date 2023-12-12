package com.klachkova.library.controllers;

import com.klachkova.library.models.Book;
import com.klachkova.library.models.Person;
import com.klachkova.library.services.BooksService;
import com.klachkova.library.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final PeopleService peopleService;
    private final BooksService booksService;


    @Autowired
    public BooksController(PeopleService peopleService, BooksService booksService) {
        this.peopleService = peopleService;
        this.booksService = booksService;
    }

    @GetMapping()
    public String index(Model model,
                        @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "books_per_page", required = false) Integer books_per_page,
                        @RequestParam(value = "sort_by_year", required = false) Boolean sort_by_year
    ) {

        List<Book> books = booksService.findAll();

        if (sort_by_year != null && sort_by_year) {
            Collections.sort(books, Comparator.comparing(Book::getYear));
        }

        model.addAttribute("books", books);
        model.addAttribute("page", page);
        model.addAttribute("books_per_page", books_per_page);

        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model) {
        Book book = booksService.findOne(id);
        model.addAttribute("book", booksService.findOne(id));

        model.addAttribute("person", peopleService.findByBook(book));

        model.addAttribute("people", peopleService.findAll());

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {

        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "books/new";
        }

        booksService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", booksService.findOne(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        booksService.update(id, book);
        return "redirect:/books";

    }

    @GetMapping("/{id}/free")
    public String free(@PathVariable("id") int id) {
        booksService.free(id);
        return "redirect:/books/{id}";
    }

    @PostMapping("/{id}")
    public String assign(@RequestParam("person_id") int selectedPerson_id,
                         @PathVariable("id") int id) {

        Person person = peopleService.findOne(selectedPerson_id);
        booksService.assign(person, id);

        return "redirect:/books/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(value = "searchTerm", required = false) String searchTerm) {

        System.out.println("search term is: " + searchTerm);

        List<Book> books = new ArrayList<>();
        if (searchTerm != null && searchTerm.length()>0) {
            books = booksService.findAll(searchTerm);
        }

        model.addAttribute("books", books);
        return "books/search";
    }
}
