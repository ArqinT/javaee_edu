package com.arqin.dairy.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by artemtursunov on 16.12.16.
 */
@Entity
@Table(name = "journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "journal_gen")
    @SequenceGenerator(name = "journal_gen", sequenceName = "journal_journal_id_gen")
    @Column(name = "journal_id")
    private Long journalId;

    @Column(name = "journal_created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "person_id")
    public Person person;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
