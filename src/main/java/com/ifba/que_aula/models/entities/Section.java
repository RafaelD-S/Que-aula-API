package com.ifba.que_aula.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "is_strike", nullable = false)
    private Boolean isStrike;

    @ManyToOne
    @JoinColumn(name = "fk_code_subject", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    public Section() {}

    public Section(String code, Boolean isStrike, Subject subject) {
        this.code = code;
        this.isStrike = isStrike;
        this.subject = subject;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Boolean getIsStrike() { return isStrike; }
    public void setIsStrike(Boolean isStrike) { this.isStrike = isStrike; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
