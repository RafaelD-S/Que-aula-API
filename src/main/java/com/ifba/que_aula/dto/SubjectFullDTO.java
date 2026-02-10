package com.ifba.que_aula.dto;

import java.util.List;

public class SubjectFullDTO {
    private final String code;
    private final String name;
    private final List<SectionResponseDTO> sections;

    public SubjectFullDTO(String code, String name, List<SectionResponseDTO> sections) {
        this.code = code;
        this.name = name;
        this.sections = sections;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public List<SectionResponseDTO> getSections() { return sections; }
}
