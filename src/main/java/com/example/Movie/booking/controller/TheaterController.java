package com.example.Movie.booking.controller;


import com.example.Movie.booking.model.Theater;
import com.example.Movie.booking.repository.MovieRepository;
import com.example.Movie.booking.repository.TheaterRepository;
import com.example.Movie.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TheaterController {
    @Autowired
    private TheaterRepository theaterRepository;


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;



    @GetMapping("/get-theater-list")
    public String getAllModels(Model model) {
        List<Theater> theater= theaterRepository.findAll();
        model.addAttribute("theater", theater);
        return "list-of-theater";
    }

    // Get all theaters
    @GetMapping("/addTheater")
    public String add(Model model) {
        model.addAttribute("movieList",movieRepository.findAll().stream().toList());
        model.addAttribute("userList",userRepository.findAll().stream().toList());

        model.addAttribute("theater",new Theater());
        return "addTheater";
    }

    // Get a theater by ID
    @PostMapping("/addTheater")
    public String addTheater(Theater theater) {
        System.out.println(theater);
        theaterRepository.save(theater);
        return "redirect:/get-theater-list";
    }

    @GetMapping("/updateTheater/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Theater theater = theaterRepository.findById(id).get();
        model.addAttribute("theater", theater);
        return "update-theaters";
    }

    @PostMapping("/updateTheater/{id}")
    public String updateTheatre(@ModelAttribute("theater") Theater theater) {
        theaterRepository.save(theater);
        // Redirect to the list of problems page
        return "redirect:/get-theater-list";
    }


    @RequestMapping("/deleteTheater/{id}")
    public String deleteMovie(@PathVariable Long id) {
        theaterRepository.deleteById(id);
        return "redirect:/get-theater-list";
    }
}

