package com.ifba.que_aula.dto;

public class SectionResponseDTO {
    private final String code;
    private final Boolean isStrike;
    private final String subjectCode;

    public SectionResponseDTO(String code, Boolean isStrike, String subjectCode) {
        this.code = code;
        this.isStrike = isStrike;
        this.subjectCode = subjectCode;
    }

    public String getCode() { return code; }
    public Boolean getIsStrike() { return isStrike; }
    public String getSubjectCode() { return subjectCode; }
}