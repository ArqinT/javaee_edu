package ru.ntdev.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by atursunov on 13.01.17.
 */
@Entity
public class Employee {
    private @Id @GeneratedValue Long id;

    public String lastName, firstName, description;

    private Employee() {}

    public Employee(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

}
