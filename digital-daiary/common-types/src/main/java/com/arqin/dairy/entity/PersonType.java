package com.arqin.dairy.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by artemtursunov on 15.12.16.
 */
@Entity
@Table(name = "Nperson_type")
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

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "personType")

    public List<Person> persons;

    public PersonType() {

    }

    public PersonType(Long personType) {
        this.typeId = personType;
    }

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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
