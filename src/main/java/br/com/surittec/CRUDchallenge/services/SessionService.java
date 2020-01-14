/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.services;

import br.com.surittec.CRUDchallenge.models.session.LevelENUM;
import br.com.surittec.CRUDchallenge.models.session.Session;
import br.com.surittec.CRUDchallenge.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jardelmc
 */
@Service
public class SessionService {

    @Autowired
    UserRepository userRepository;

    public String createToken(Session session) {
        Session auth = userRepository.findById(session.getUsername()).get();

        if (!auth.getPassword().equals(session.getPassword())) {
            return null;
        }

        String jwt = JWT.create()
                .withClaim("level", auth.getLevel().toString())
                .sign(Algorithm.HMAC256("surittec"));

        return jwt;
    }

    public String validadeToken(String token) {
        String[] bearer = token.split(" ");
        
        
        DecodedJWT decodedJwt = JWT
                .require(Algorithm.HMAC256("surittec"))
                .build()
                .verify(bearer[1]);
        
        return decodedJwt.getClaim("level").asString();
    }
}
