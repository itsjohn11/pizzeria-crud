package org.lessons.java.spring.pizzeria_crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring.pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizzas")
public class PizzaController<Pizza> {

    @Autowired
    private PizzaRepository pizzaRepository;
    
    @GetMapping
    public String index(Model model){
        List<Pizza> pizzas =  pizzaRepository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }
    
}
