package com.ifba.que_aula.dto;

public class CourseResponseDTO {

    private final Long idCourse;
    private final String sectionCode;
    private final String subjectCode;
    private final String teacher;
    private final String classroom;
    private final int weekday;
    private final int periodStart;
    private final int periodEnd;

    public CourseResponseDTO(
            Long idCourse,
            String sectionCode,
            String subjectCode,
            String teacher,
            String classroom,
            int weekday,
            int periodStart,
            int periodEnd
    ) {
        this.idCourse = idCourse;
        this.sectionCode = sectionCode;
        this.subjectCode = subjectCode;
        this.teacher = teacher;
        this.classroom = classroom;
        this.weekday = weekday;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

    public Long getIdCourse() { return idCourse; }
    public String getSectionCode() { return sectionCode; }
    public String getSubjectCode() { return subjectCode; }
    public String getTeacher() { return teacher; }
    public String getClassroom() { return classroom; }
    public int getWeekday() { return weekday; }
    public int getPeriodStart() { return periodStart; }
    public int getPeriodEnd() { return periodEnd; }
}