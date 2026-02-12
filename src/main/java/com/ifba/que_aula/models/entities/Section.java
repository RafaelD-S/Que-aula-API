package com.ifba.que_aula.models.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "section")
public class Section {

    @EmbeddedId
    private SectionId id;

    @Column(name = "is_strike", nullable = false)
    private Boolean isStrike;

    @MapsId("subjectCode")
    @ManyToOne
    @JoinColumn(name = "fk_code_subject", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    public Section() {}

    public Section(String code, Boolean isStrike, Subject subject) {
        this.id = new SectionId(code, subject != null ? subject.getCode() : null);
        this.isStrike = isStrike;
        this.subject = subject;
    }

    public SectionId getId() { return id; }
    public void setId(SectionId id) { this.id = id; }

    public String getCode() { return id != null ? id.getCode() : null; }
    public void setCode(String code) {
        if (this.id == null) {
            this.id = new SectionId();
        }
        this.id.setCode(code);
    }

    public Boolean getIsStrike() { return isStrike; }
    public void setIsStrike(Boolean isStrike) { this.isStrike = isStrike; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) {
        this.subject = subject;
        if (this.id == null) {
            this.id = new SectionId();
        }
        this.id.setSubjectCode(subject != null ? subject.getCode() : null);
    }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}
