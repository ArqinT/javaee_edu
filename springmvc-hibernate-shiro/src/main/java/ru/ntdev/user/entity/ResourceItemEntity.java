/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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

   @ManyToOne
   @JoinColumn(name = "type_id")
   private ResourceTypeEntity type;

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
     * @param type the type to set
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
   
   
}
