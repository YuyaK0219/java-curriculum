package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/save")
    public String showForm(@RequestParam(name = "id", required = false) Long id, Model model) {
        if (id != null) {
            model.addAttribute("todo", todoService.findById(id).orElse(new Todo()));
        } else {
            model.addAttribute("todo", new Todo());
        }
        return "form";
    }

    @PostMapping("/save")
    public String submitForm(@ModelAttribute Todo todo) {
        todoService.save(todo);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "list";
    }

    @PostMapping("/delete")
    public String deleteTodo(@RequestParam("id") Long id) {
        todoService.deleteById(id);  // 完了済みかどうかに関係なく削除
        return "redirect:/list";
    }

    @PostMapping("/complete")
    public String markAsCompleted(@RequestParam("id") Long id) {
        todoService.markAsCompleted(id);
        return "redirect:/list";
    }
}