/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.repositories;

import br.com.surittec.CRUDchallenge.models.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jardelmc
 */
public interface UserRepository extends JpaRepository<Session, String>{
    
}
