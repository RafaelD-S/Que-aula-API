package com.ifba.que_aula.dto;

public class CourseResponseDTO {

    private final Long idCourse;
    private final String sectionCode;
    private final String teacher;
    private final String classroom;
    private final String weekday;
    private final String period;

    public CourseResponseDTO(
            Long idCourse,
            String sectionCode,
            String teacher,
            String classroom,
            String weekday,
            String period
    ) {
        this.idCourse = idCourse;
        this.sectionCode = sectionCode;
        this.teacher = teacher;
        this.classroom = classroom;
        this.weekday = weekday;
        this.period = period;
    }

    public Long getIdCourse() { return idCourse; }
    public String getSectionCode() { return sectionCode; }
    public String getTeacher() { return teacher; }
    public String getClassroom() { return classroom; }
    public String getWeekday() { return weekday; }
    public String getPeriod() { return period; }
}