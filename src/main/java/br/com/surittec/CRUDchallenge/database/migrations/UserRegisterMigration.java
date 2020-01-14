/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.database.migrations;

import br.com.surittec.CRUDchallenge.models.session.LevelENUM;
import br.com.surittec.CRUDchallenge.models.session.Session;
import br.com.surittec.CRUDchallenge.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jardelmc
 */

@Component
public class UserRegisterMigration implements InitializingBean{
   @Autowired
   UserRepository userRepository;
   
   @Override
   public void afterPropertiesSet() throws Exception{
       initializeUsers();
   }
    
   private void initializeUsers() {
       Session normalUser = new Session();
       
       normalUser.setUsername("user");
       normalUser.setPassword("123456");
       normalUser.setLevel(LevelENUM.NORMAL);
       
       userRepository.save(normalUser);
       
       Session adminUser = new Session();
       
       adminUser.setUsername("admin");
       adminUser.setPassword("123456");
       adminUser.setLevel(LevelENUM.ADMINISTRADOR);
       
       userRepository.save(adminUser);
   }

}
