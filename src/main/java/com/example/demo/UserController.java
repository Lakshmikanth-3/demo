package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user, Model model) {
        repo.save(user);
        model.addAttribute("msg", "Saved Successfully!");
        return "index";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("users", repo.findAll());
        return "index";
    }
}