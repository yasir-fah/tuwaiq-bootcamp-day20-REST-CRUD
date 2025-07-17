package com.example.day20exercise.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private String id;
    private String userName;
    private double balance;

}
