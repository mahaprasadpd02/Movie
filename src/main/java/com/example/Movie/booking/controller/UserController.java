package com.example.Movie.booking.controller;

import com.example.Movie.booking.model.Movie;
import com.example.Movie.booking.model.User;
import com.example.Movie.booking.repository.UserRepository;
//import com.example.Movie.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/get-user-list")
    public String getAllModels(Model model) {
        List<User> user= userRepository.findAll();
        model.addAttribute("user", user);
        return "list-of-user";
    }

    @GetMapping("/addUser")
    public String add(){
        return "create-user";
    }

    // Create a new movie
    @PostMapping("/addUser")
    public String addMovie(User user) {
        userRepository.save(user);
        return "redirect:/get-user-list";

    }

    // Update a movie
    @GetMapping("/updateUser/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/updateUser/{id}")
    public String updateComplain(@ModelAttribute("movie") User user) {
        userRepository.save(user);
        // Redirect to the list of problems page
        return "redirect:/get-user-list";
    }


    @RequestMapping("/deleteUser/{id}")
    public String deleteMovie(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/get-user-list";
    }

}
