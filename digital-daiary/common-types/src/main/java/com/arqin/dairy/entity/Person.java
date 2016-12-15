package com.arqin.dairy.entity;



import javax.persistence.*;

/**
 * Created by artemtursunov on 14.12.16.
 */

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_gen")
    @SequenceGenerator(name = "person_gen", sequenceName = "person_person_id_seq")
    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "person_name", nullable = false)
    private String name;

    @Column(name = "person_surname", nullable = false)
    private String surname;

    @Column(name = "person_patronymic")
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "person_type_id")
    private PersonType personType;

    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
    }

    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return this.surname+" "+this.name+" "+this.patronymic;
    }
}
