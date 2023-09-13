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


    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("article", new Article());
        return "/article/add-article";
    }

    @PostMapping("/add")
    public String processAddForm(Article article) {
        articleDao.saveArticle(article);
        return "redirect:/article/showAll";
    }


    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute(articleDao.findArticleById(id));
        return "/article/update-article";

    }

    @PostMapping("/update")
    public String processUpdateForm(Article article) {
        articleDao.updateArticle(article);
        return "redirect:/article/showAll";
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


    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAllAuthors();
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryDao.findAllCategories();
    }

}
