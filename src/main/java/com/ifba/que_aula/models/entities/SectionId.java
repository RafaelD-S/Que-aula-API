package com.ifba.que_aula.models.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SectionId implements Serializable {

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "fk_code_subject", nullable = false)
    private String subjectCode;

    public SectionId() {}

    public SectionId(String code, String subjectCode) {
        this.code = code;
        this.subjectCode = subjectCode;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getSubjectCode() { return subjectCode; }
    public void setSubjectCode(String subjectCode) { this.subjectCode = subjectCode; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SectionId sectionId = (SectionId) o;
        return Objects.equals(code, sectionId.code)
                && Objects.equals(subjectCode, sectionId.subjectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subjectCode);
    }
}
