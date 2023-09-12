package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String addAuthor(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.saveAuthor(author);
        model.addAttribute("author", author);
        return "author-add";
    }


}
