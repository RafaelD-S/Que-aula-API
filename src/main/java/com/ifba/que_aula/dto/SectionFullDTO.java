package com.ifba.que_aula.dto;

import java.util.List;

public class SectionFullDTO {
    private final String code;
    private final Boolean isStrike;
    private final String subjectCode;
    private final List<CourseResponseDTO> courses;

    public SectionFullDTO(String code, Boolean isStrike, String subjectCode, List<CourseResponseDTO> courses) {
        this.code = code;
        this.isStrike = isStrike;
        this.subjectCode = subjectCode;
        this.courses = courses;
    }

    public String getCode() { return code; }
    public Boolean getIsStrike() { return isStrike; }
    public String getSubjectCode() { return subjectCode; }
    public List<CourseResponseDTO> getCourses() { return courses; }
}
