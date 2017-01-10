/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vminakov
 */
@Entity
@Table(name = "users")
public class UserEntity {
    
    @Id
    @SequenceGenerator(name="users_id_seq",
                       sequenceName="users_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="users_id_seq")
    @Column(name = "id", updatable=false)
    private int id;
   
    private String username;
    
    private String password;
    
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false) },
                    inverseJoinColumns = { @JoinColumn(name = "role_id",nullable = false, updatable = false) 
    })
    private Set<RoleEntity> roles;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
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
    
    public Set<RoleEntity> getRoles() {
        return roles;
    }
    
    public void setRoles(Set<RoleEntity> userRoles) {
        this.roles = userRoles;
    }
            
    
    @Override
    public String toString(){
            return "id="+id+", username="+username+", password="+password;
    }
    
    
    
}
