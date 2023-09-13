package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/showAll")
    public String showAllArticles(Model model) {
        model.addAttribute("articles", articleDao.findAllArticles());
        return "/article/show-all-articles";
    }



    @RequestMapping("/delete")
    public String deleteArticle(@RequestParam Long id) {
        articleDao.deleteArticle(articleDao.findArticleById(id));
        return "redirect:/article/showAll";
    }
    @RequestMapping("/confirmDelete")
    public String confirmDelete() {
        return "article/confirm-delete";
    }

}
