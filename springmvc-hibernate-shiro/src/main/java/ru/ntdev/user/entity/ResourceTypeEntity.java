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
 * @author vminakov
 */
@Entity
@Table(name = "resource_types")
public class ResourceTypeEntity {
    @Id
    @SequenceGenerator(name = "resource_types_id_seq", sequenceName = "resource_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resource_types_id_seq")
    private int id;
    private String code;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "type",
            cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
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
     * @return List<ResourceItemEntity>
     */
    public List<ResourceItemEntity> getResources() {
        return resources;
    }

    public void setResources(List<ResourceItemEntity> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " Code: " + this.code;
    }
}
