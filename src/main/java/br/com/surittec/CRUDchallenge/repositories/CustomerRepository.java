/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.repositories;

import br.com.surittec.CRUDchallenge.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jardelmc
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCpf(Long cpf);
}
