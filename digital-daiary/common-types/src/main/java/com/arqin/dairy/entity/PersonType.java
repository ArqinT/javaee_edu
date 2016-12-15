package com.arqin.dairy.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by artemtursunov on 15.12.16.
 */
@Entity
@Table(name = "person_type")
public class PersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_type_gen")
    @SequenceGenerator(name = "person_type_gen", sequenceName = "person_type_person_type_id_seq")
    @Column(name = "person_type_id")
    public Long typeId;
    @Column(name = "person_type_code")
    public String typeCode;
    @Column(name = "person_type_description")
    public String typeDescription;

    @OneToMany
    @JoinColumn(name = "person_type_id")
    public Set<Person> persons = new HashSet<Person>();

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
