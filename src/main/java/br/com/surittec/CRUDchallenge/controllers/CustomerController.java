/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.controllers;

import br.com.surittec.CRUDchallenge.models.customer.Customer;
import br.com.surittec.CRUDchallenge.services.CustomerService;
import br.com.surittec.CRUDchallenge.services.SessionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 * @author Jardelmc
 */
@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {

    @Autowired
    SessionService sessionService;
    
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> create(
            @RequestHeader("Authorization") String token,
            @RequestBody @Valid Customer customer, BindingResult result) {
        
        String level = sessionService.validadeToken(token);
        
        if(!level.equals("ADMINISTRADOR")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        if (customerService.createCustomer(customer, result)) {
            return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Customer>> index( @RequestHeader("Authorization") String token) {
         String level = sessionService.validadeToken(token);
        
        if(!level.equals("ADMINISTRADOR") && !level.equals("NORMAL")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        
        List<Customer> allCustomer = customerService.indexAll();
        
        return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.FOUND);
    }
    
}
