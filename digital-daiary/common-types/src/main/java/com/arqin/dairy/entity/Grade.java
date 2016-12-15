package com.arqin.dairy.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by artemtursunov on 14.12.16.
 */
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "grade_gen")
    @SequenceGenerator(name = "grade_gen", sequenceName = "grade_grade_id_seq")
    @Column(name = "grade_id")
    public Long gradeId;

    @Column(name = "grade_description")
    public String description;

    @Column(name = "grade_code")
    public String gradeCode;

    public Grade() {
    }

    public Grade(String code, String description) {
        this.gradeCode = code;
        this.description = description;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }
}
