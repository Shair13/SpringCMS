package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.model.Category;

import javax.validation.Valid;
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

    @PostMapping("/add")
    public String processAddForm(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/add-category";
        }
        categoryDao.saveCategory(category);
        return "redirect:/category/showAll";
    }

    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute("category", categoryDao.findCategoryById(id));
        return "/category/update-category";
    }

    @PostMapping("/update")
    public String processUpdateForm(@Valid Category category, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "category/update-category";
        }
        categoryDao.updateCategory(category);
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
