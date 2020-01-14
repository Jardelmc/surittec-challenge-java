/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.services;

import br.com.surittec.CRUDchallenge.models.customer.Customer;
import br.com.surittec.CRUDchallenge.repositories.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 *
 * @author Jardelmc
 */
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public boolean createCustomer(Customer customer, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return false;
            }

            if (!customerRepository.existsById(customer.getCpf())) {
                customerRepository.save(customer);

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Customer> indexAll() {
        List<Customer> allCustomers = customerRepository.findAll();
        
        return allCustomers;
    }
}
