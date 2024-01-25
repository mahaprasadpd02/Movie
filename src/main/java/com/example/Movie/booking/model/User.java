package com.example.Movie.booking.model;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;



@Data
@Entity
@ToString
@Table(name = "User_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String username;
    private String email;
    @ManyToOne()
    private Theater theater;
}
