package org.lessons.java.spring.pizzeria_crud.controller;

import org.lessons.java.spring.pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;
    
    @GetMapping
    public String index(Model model){
        model.addAttribute("pizzas", pizzaRepository.findAll());
        return "pizzas/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model){
        model.addAttribute("id",pizzaRepository.findById(id).get());
        return "pizzas/show";
    }
    
}
