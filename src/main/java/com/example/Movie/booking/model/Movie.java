package com.example.Movie.booking.model;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String title;
    private String director;
    private LocalDate releaseDate;

    @ManyToOne()
    private Theater theater;

}

