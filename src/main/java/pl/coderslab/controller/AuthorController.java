package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/showAll")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "/author/show-all-authors";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "/author/add-author";
    }

    @PostMapping("/add")
    public String processAddForm(@Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/author/add-author";
        }
        authorRepository.save(author);
        return "redirect:/author/showAll";
    }

    @RequestMapping("/delete")
    public String deleteAuthor(@RequestParam Long id) {
        authorRepository.delete(authorRepository.findById(id).get());
        return "redirect:/author/showAll";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete() {
        return "author/confirm-delete";
    }

    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute(authorRepository.findById(id).get());
        return "/author/update-author";

    }

    @PostMapping("/update")
    public String processUpdateForm(@Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author/update-author";
        }
        authorRepository.save(author);
        return "redirect:/author/showAll";
    }
}
