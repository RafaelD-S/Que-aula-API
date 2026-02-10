package com.ifba.que_aula.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseDTO {
    private Long idCourse;

    @NotBlank
    private String sectionCode;

    @NotBlank
    private String teacher;

    @NotBlank
    private String classroom;

    @NotBlank
    private String weekday;

    @NotBlank
    private String period;

    public Long getIdCourse() { return idCourse; }
    public void setIdCourse(Long idCourse) { this.idCourse = idCourse; }

    public String getSectionCode() { return sectionCode; }
    public void setSectionCode(String sectionCode) { this.sectionCode = sectionCode; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public String getClassroom() { return classroom; }
    public void setClassroom(String classroom) { this.classroom = classroom; }

    public String getWeekday() { return weekday; }
    public void setWeekday(String weekday) { this.weekday = weekday; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
}
