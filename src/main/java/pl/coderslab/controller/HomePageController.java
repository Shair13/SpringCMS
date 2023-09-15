package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Article;
import pl.coderslab.model.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ArticleRepository articleRepository;



    @RequestMapping("/")
    public String home() {
        return "home/home";
    }

    @RequestMapping("/articleByCategory")
    public String getArticleByCategory(@RequestParam Long id, Model model){
        Category category = categoryRepository.findById(id).get();
        List<Article> articlesByCategory = articleRepository.findByCategories(category);
        if(articlesByCategory.isEmpty()){
            return "home/no-article";
        }
        model.addAttribute("articles", articlesByCategory);
        return "article/show-articles-by-category";
    }

    @ModelAttribute("lastFiveArticles")
    public List<Article> lastFiveArticles() {
        return articleRepository.findFirst5ByOrderByCreatedDesc();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}

