package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Article;
import pl.coderslab.model.Category;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping("/")
    public String home() {
        return "home/home";
    }

    @RequestMapping("/articleByCategory")
    public String getArticleByCategory(@RequestParam Long id, Model model){
        Category category = categoryDao.findCategoryById(id);
        List<Article> articlesByCategory = articleDao.findArticlesByCategory(category);
        if(articlesByCategory.isEmpty()){
            return "home/no-article";
        }
        model.addAttribute("articles", articlesByCategory);
        return "article/show-articles-by-category";
    }

    @ModelAttribute("lastFiveArticles")
    public List<Article> lastFiveArticles() {
        return articleDao.findFiveLastArticles();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAllCategories();
    }
}

