package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public ArticleController(ArticleRepository articleRepository,
                             AuthorRepository authorRepository,
                             CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "/article/add-article";
    }

    @PostMapping("/add")
    public String processAddForm(@Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/article/add-article";
        }
        articleRepository.save(article);
        return "redirect:/article/showAll";
    }


    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute("article", articleRepository.findById(id).get());
        return "/article/update-article";

    }

    @PostMapping("/update")
    public String processUpdateForm(@Valid Article article, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/article/update-article";
        }
        articleRepository.save(article);
        return "redirect:/article/showAll";
    }

    @GetMapping("/showAll")
    public String showAllArticles(Model model) {
        model.addAttribute("articles", articleRepository.findAll());
        return "/article/show-all-articles";
    }


    @RequestMapping("/delete")
    public String deleteArticle(@RequestParam Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        optionalArticle.ifPresent(articleRepository::delete);
        return "redirect:/article/showAll";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete() {
        return "article/confirm-delete";
    }


    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

}
