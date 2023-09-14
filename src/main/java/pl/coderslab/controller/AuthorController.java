package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/showAll")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAllAuthors());
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
        authorDao.saveAuthor(author);
        return "redirect:/author/showAll";
    }

    @RequestMapping("/delete")
    public String deleteAuthor(@RequestParam Long id) {
        authorDao.deleteAuthor(authorDao.findAuthorById(id));
        return "redirect:/author/showAll";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete() {
        return "author/confirm-delete";
    }

    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute(authorDao.findAuthorById(id));
        return "/author/update-author";

    }

    @PostMapping("/update")
    public String processUpdateForm(@Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "author/update-author";
        }
        authorDao.updateAuthor(author);
        return "redirect:/author/showAll";
    }
}
