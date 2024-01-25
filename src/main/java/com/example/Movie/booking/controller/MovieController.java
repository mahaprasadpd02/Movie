package com.example.Movie.booking.controller;

import com.example.Movie.booking.model.Movie;
import com.example.Movie.booking.model.User;
import com.example.Movie.booking.repository.MovieRepository;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller

public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

//    @GetMapping("/login")
//
//    public String loginForm(){
//        return "login";
//    }
    // Get all movies
    @GetMapping("/user/home")
    public String getAllMovies() {
        return "homepage";
    }

    @GetMapping("/get-movie-list")
    public String getAllModels(Model model) {
        List<Movie> movie= movieRepository.findAll();
        model.addAttribute("movie", movie);
        return "list-of-movie";
    }

    // Get a movie by ID
    @GetMapping("/addMovie")
    public String add(){
        return "addMovie";
    }

    // Create a new movie
    @PostMapping("/addMovie")
    public String addMovie(Movie movie) {
        movieRepository.save(movie);
        return "redirect:/get-movie-list";

    }

  //   Update a movie
    @GetMapping("/updateMovie/{id}")
    public String getEditForm(@PathVariable("id") Long id, Model model) {
        Movie movie = movieRepository.findById(id).get();
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @PostMapping("/updateMovie")
    public String updateComplain(@ModelAttribute("movie") Movie movie) {
        movieRepository.save(movie);
        // Redirect to the list of problems page
        return "redirect:/get-movie-list";
    }


    @RequestMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return "redirect:/get-movie-list";
    }
//    @GetMapping("/logout")
//    public RedirectView logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//        request.logout();
//        Cookie[] list=request.getCookies();
//        for (Cookie cookie:list){
//            Cookie cookie1=new Cookie(cookie.getName(),null);
//            cookie1.setMaxAge(0);
//            cookie1.setPath("/");
//            response.addCookie(cookie1);
//        }
//        response.setHeader("pragma", "no-cache");
//        response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
//        response.setHeader("Expires", "0");
//        request.getSession().invalidate();
//        return new RedirectView("/login", true);
//    }
}

