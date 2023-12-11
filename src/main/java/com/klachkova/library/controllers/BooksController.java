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

@Controller
@RequestMapping("/books")
public class BooksController {
    private final PeopleService peopleService;
    private final BooksService booksService;



    @Autowired
    public BooksController( PeopleService peopleService, BooksService booksService) {
        this.peopleService = peopleService;
        this.booksService = booksService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", booksService.findAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model ) {
        Book book = booksService.findOne(id);
        model.addAttribute("book", booksService.findOne(id));
        // есть метод поиска человека по книге в peopleRepository вызывает ошибку
        model.addAttribute("person",peopleService.findByBook(book));

        model.addAttribute("people",peopleService.findAll());

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book")Book book) {

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
   @GetMapping ("/{id}/free")
   public String free ( @PathVariable("id") int id) {
       booksService.free (id);
       return "redirect:/books/{id}";
    }

    //необходимо принимать человека а не его айди @RequestParam("person_id") int selectedPerson_id,изменено
    @PostMapping("/{id}")
    public String assign (@RequestParam("person_id")  int selectedPerson_id,
                          @PathVariable("id") int id){

        Person person = peopleService.findOne(selectedPerson_id);
        booksService.assign (person,id);

        return "redirect:/books/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }
}
