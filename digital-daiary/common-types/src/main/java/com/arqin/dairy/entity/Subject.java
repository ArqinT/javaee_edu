package com.arqin.dairy.entity;

import javax.persistence.*;

/**
 * Created by artemtursunov on 14.12.16.
 */
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "subject_gen")
    @SequenceGenerator(name = "subject_gen", sequenceName = "subject_subject_id_seq")
    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(name = "subject_name")
    private String name;


    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
