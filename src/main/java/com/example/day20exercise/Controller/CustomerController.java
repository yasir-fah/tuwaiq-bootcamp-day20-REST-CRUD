package com.example.day20exercise.Controller;

import com.example.day20exercise.Api.ApiResponse;
import com.example.day20exercise.Model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Customer> getCustomer() {
        return customers;
    }


    @PostMapping("/post")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.ok(customer);
    }


    @PutMapping("/put/{index}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int index, @RequestBody Customer customer) {

        if (index >= customers.size()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            customers.set(index, customer);
            return ResponseEntity.ok(customer);
        }
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index) {

        if (index >= customers.size()) {
            return new ApiResponse("out of bound, maximum size is: " + (customers.size() - 1), "");
        }
        else {
            customers.remove(index);
            return new ApiResponse("customer deleted successfully", "200 ok");
        }
    }

    @PutMapping("/put/deposit/{id}")
    public ApiResponse deposit(@PathVariable String id, @RequestBody Customer depositReq) {

        double amount = depositReq.getBalance();

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customer.setBalance(customer.getBalance() + amount);
                return new ApiResponse("deposit done successfully !", "200 ok");
            }
        }

        return new ApiResponse("no deposit has been done yet", "404 not found");
    }

    @PutMapping("/put/withdraw/{id}")
    public String withdraw(@PathVariable String id, @RequestBody Customer withdrawReq) {

        double amount = withdrawReq.getBalance(); // user add it from body

        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                if(customer.getBalance() >= amount){
                    customer.setBalance(customer.getBalance() - amount);
                    return "withdraw has been done successfully, new balance is:" + customer.getBalance();
                }else{
                    return "Insufficient funds";
                }
            }
        }
        return "Customer with id = " + id + " not found";
    }
}