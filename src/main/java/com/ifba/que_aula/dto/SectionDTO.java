package com.ifba.que_aula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SectionDTO {
    @NotBlank
    private String code;

    @NotNull
    private Boolean isStrike;

    @NotBlank
    private String subjectCode;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Boolean getIsStrike() { return isStrike; }
    public void setIsStrike(Boolean isStrike) { this.isStrike = isStrike; }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }
}
