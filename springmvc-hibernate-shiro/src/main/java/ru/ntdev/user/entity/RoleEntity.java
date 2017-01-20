/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.entity;

import java.util.List;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vminakov
 */
@Entity
@Table(name="roles")
public class RoleEntity {
    @Id
    @SequenceGenerator(name="roles_id_seq",
                       sequenceName="roles_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="roles_id_seq")
    @Column(name="id")
    private int id;
    
    private String code;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "role_resources", joinColumns = {
                    @JoinColumn(name = "role_id", nullable = false, updatable = false) },
                    inverseJoinColumns = { @JoinColumn(name = "resource_id",nullable = false, updatable = false) 
    })
    private List<ResourceItemEntity> resources;

    /**
     * @return the id
     */
    public int getId() {
        return id;
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

    /**
     * @return the resources
     */
    public List<ResourceItemEntity> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(List<ResourceItemEntity> resources) {
        this.resources = resources;
    }
    
    
}
