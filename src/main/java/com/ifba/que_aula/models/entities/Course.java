package com.ifba.que_aula.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCourse;

    @ManyToOne
    @JoinColumn(name = "fk_code_section", nullable = false)
    private Section section;

    @Column(nullable = false)
    private String teacher;

    @Column(nullable = false)
    private String classroom;

    @Column(nullable = false)
    private String weekday;

    @Column(nullable = false)
    private String period;

    public Course() {}

    public Course(Section section, String teacher, String classroom, String weekday, String period) {
        this.section = section;
        this.teacher = teacher;
        this.classroom = classroom;
        this.weekday = weekday;
        this.period = period;
    }

    public Long getIdCourse() { return idCourse; }
    public void setIdCourse(Long idCourse) { this.idCourse = idCourse; }

    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public String getClassroom() { return classroom; }
    public void setClassroom(String classroom) { this.classroom = classroom; }

    public String getWeekday() { return weekday; }
    public void setWeekday(String weekday) { this.weekday = weekday; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
}
