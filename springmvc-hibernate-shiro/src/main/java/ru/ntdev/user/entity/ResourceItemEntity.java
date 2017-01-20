/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author vminakov
 */
@Entity
@Table(name = "resources")
public class ResourceItemEntity {
   @Id
   @SequenceGenerator(name="resources_id_seq",sequenceName="resources_id_seq",allocationSize=1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="resources_id_seq")   
   private int id;

   @Autowired
   @ManyToOne
   @JoinColumn(name = "type_id")
   private ResourceTypeEntity type;

   @Autowired
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "role_resources", joinColumns = {
            @JoinColumn(name = "resource_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
    private List<RoleEntity> roles;

   private String code;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the type
     */

    public ResourceTypeEntity getType() {
        return type;
    }

    /**
     * @param  type ResourceType
     */
    public void setType(ResourceTypeEntity type) {
        this.type = type;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }


    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " Code: " + this.code;
    }
}
