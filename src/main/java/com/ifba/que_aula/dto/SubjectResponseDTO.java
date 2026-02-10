package com.ifba.que_aula.dto;

public class SubjectResponseDTO {
    private final String code;
    private final String name;

    public SubjectResponseDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
