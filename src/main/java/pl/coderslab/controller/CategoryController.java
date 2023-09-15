package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Category;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("category")
public class CategoryController {

//  private CategoryDao categoryDao;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/showAll")
    public String getAllCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
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
        categoryRepository.save(category);
        return "redirect:/category/showAll";
    }

    @GetMapping("/update")
    public String displayUpdateForm(@RequestParam Long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "/category/update-category";
    }

    @PostMapping("/update")
    public String processUpdateForm(@Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category/update-category";
        }
        categoryRepository.save(category);
        return "redirect:/category/showAll";
    }


    @RequestMapping("/delete")
    public String deleteCategory(@RequestParam Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
            return "redirect:/category/showAll";
        }
        return "/home/no-article";
    }

    @RequestMapping("/confirmDelete")
    public String confirmDelete() {
        return "category/confirm-delete";
    }

}
