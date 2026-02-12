package com.ifba.que_aula.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
    @JoinColumns({
        @JoinColumn(name = "fk_code_section", referencedColumnName = "code", nullable = false),
        @JoinColumn(name = "fk_code_subject", referencedColumnName = "fk_code_subject", nullable = false)
    })
    private Section section;

    @Column(nullable = false)
    private String teacher;

    @Column(nullable = false)
    private String classroom;

    @Column(nullable = false)
    private int weekday;

    @Column(name = "period_start", nullable = false)
    private int periodStart;

    @Column(name = "period_end", nullable = false)
    private int periodEnd;

    public Course() {}

    public Course(
            Section section,
            String teacher,
            String classroom,
            int weekday,
            int periodStart,
            int periodEnd
    ) {
        this.section = section;
        this.teacher = teacher;
        this.classroom = classroom;
        this.weekday = weekday;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public Long getIdCourse() { return idCourse; }
    public void setIdCourse(Long idCourse) { this.idCourse = idCourse; }

    public Section getSection() { return section; }
    public void setSection(Section section) { this.section = section; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public String getClassroom() { return classroom; }
    public void setClassroom(String classroom) { this.classroom = classroom; }

    public int getWeekday() { return weekday; }
    public void setWeekday(int weekday) { this.weekday = weekday; }

    public int getPeriodStart() { return periodStart; }
    public void setPeriodStart(int periodStart) { this.periodStart = periodStart; }

    public int getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(int periodEnd) { this.periodEnd = periodEnd; }
}
