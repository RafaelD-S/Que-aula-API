package com.ifba.que_aula.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CourseDTO {
    private Long idCourse;

    @NotBlank
    private String sectionCode;

    @NotBlank
    private String subjectCode;

    @NotBlank
    private String teacher;

    @NotBlank
    private String classroom;

    @NotNull
    @Min(0)
    @Max(6)
    private Integer weekday;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer periodStart;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer periodEnd;

    public Long getIdCourse() { return idCourse; }
    public void setIdCourse(Long idCourse) { this.idCourse = idCourse; }

    public String getSectionCode() { return sectionCode; }
    public void setSectionCode(String sectionCode) { this.sectionCode = sectionCode; }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    public String getTeacher() { return teacher; }
    public void setTeacher(String teacher) { this.teacher = teacher; }

    public String getClassroom() { return classroom; }
    public void setClassroom(String classroom) { this.classroom = classroom; }

    public Integer getWeekday() { return weekday; }
    public void setWeekday(Integer weekday) { this.weekday = weekday; }

    public Integer getPeriodStart() { return periodStart; }
    public void setPeriodStart(Integer periodStart) { this.periodStart = periodStart; }

    public Integer getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(Integer periodEnd) { this.periodEnd = periodEnd; }
}
