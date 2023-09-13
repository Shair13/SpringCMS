package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Category;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("/showAll")
    public String getAllCategories(Model model) {
        List<Category> categories = categoryDao.findAllCategories();
        model.addAttribute("categories", categories);
        return "category/get-all-categories";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add-category";
    }

    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute("category", categoryDao.findCategoryById(id));
        return "/category/update-category";
    }

    @PostMapping("/update")
    public String processUpdateForm(Category category) {
        categoryDao.updateCategory(category);
        return "redirect:/category/showAll";
    }

    @PostMapping("/add")
    public String processAddForm(Category category) {
//        if (category.getId() == null) {
//            categoryDao.saveCategory(category);
//        } else {
        categoryDao.updateCategory(category);
//        }
        return "redirect:/category/showAll";
    }

    @RequestMapping("/delete")
    public String deleteCategory(@RequestParam Long id) {
        Category category = categoryDao.findCategoryById(id);
        categoryDao.deleteCategory(category);
        return "redirect:/category/showAll";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete() {
        return "category/confirm-delete";
    }

}
