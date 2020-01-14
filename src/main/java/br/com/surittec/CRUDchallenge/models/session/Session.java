/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.surittec.CRUDchallenge.models.session;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jardelmc
 */

@Entity
@Table(name = "user")
public class Session {
    
    
    @Id
    private String username;
    private String password;
    
    private LevelENUM level;
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LevelENUM getLevel() {
        return level;
    }

    public void setLevel(LevelENUM level) {
        this.level = level;
    }
    
    
}
