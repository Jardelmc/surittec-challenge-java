/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.controllers;

import br.com.surittec.CRUDchallenge.models.session.LevelENUM;
import br.com.surittec.CRUDchallenge.models.session.Session;
import br.com.surittec.CRUDchallenge.repositories.UserRepository;
import br.com.surittec.CRUDchallenge.services.SessionService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jardelmc
 */
@RestController
@RequestMapping(value = "/api/v1/session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @PostMapping
    public ResponseEntity login(@RequestBody Session session) {
        try {

            String token = sessionService.createToken(session);

            if (token != null) {
                return ResponseEntity.ok().body(token);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
