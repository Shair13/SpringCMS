package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.model.Article;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ArticleDao articleDao;


    @RequestMapping("/")
    public String home() {
        return "home/home";
    }

    @ModelAttribute("lastFiveArticles")
    public List<Article> lastFiveArticles() {
        return articleDao.findFiveLastArticles();
    }
}

