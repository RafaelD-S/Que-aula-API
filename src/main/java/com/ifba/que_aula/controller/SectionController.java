package com.ifba.que_aula.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifba.que_aula.dto.CourseResponseDTO;
import com.ifba.que_aula.dto.SectionDTO;
import com.ifba.que_aula.dto.SectionFullDTO;
import com.ifba.que_aula.dto.SectionResponseDTO;
import com.ifba.que_aula.models.entities.Section;
import com.ifba.que_aula.service.SectionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionService service;

    public SectionController(SectionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SectionFullDTO> getAll() {
        return service.findAll().stream()
                .map(s -> new SectionFullDTO(
                    s.getCode(),
                    s.getIsStrike(),
                    s.getSubject().getCode(),
                    s.getCourses().stream()
                        .map(course -> new CourseResponseDTO (
                            course.getIdCourse(),
                            course.getSection().getCode(),
                            course.getSection().getSubject().getCode(),
                            course.getTeacher(),
                            course.getClassroom(),
                            course.getWeekday(),
                            course.getPeriodStart(),
                            course.getPeriodEnd()
                        )).toList()
                )).toList();
    }

    @GetMapping("/{subjectCode}/{code}")
    public SectionFullDTO getById(@PathVariable String subjectCode, @PathVariable String code) {
        Section s = service.findById(code, subjectCode);
        return new SectionFullDTO(
            s.getCode(),
            s.getIsStrike(),
            s.getSubject().getCode(),
            s.getCourses().stream()
                .map(course -> new CourseResponseDTO(
                    course.getIdCourse(),
                    course.getSection().getCode(),
                    course.getSection().getSubject().getCode(),
                    course.getTeacher(),
                    course.getClassroom(),
                    course.getWeekday(),
                    course.getPeriodStart(),
                    course.getPeriodEnd()
                ))
                .toList()
        );
    }

    @PostMapping
    public SectionResponseDTO create(@Valid @RequestBody SectionDTO dto) {
        Section s = new Section(dto.getCode(), dto.getIsStrike(), null);
        Section created = service.create(s, dto.getSubjectCode());
        return new SectionResponseDTO(
            created.getCode(),
            created.getIsStrike(),
            created.getSubject().getCode()
        );
    }

    @PutMapping("/{subjectCode}/{code}")
    public Section update(
            @PathVariable String subjectCode,
            @PathVariable String code,
            @Valid @RequestBody SectionDTO dto
    ) {
        Section section = new Section(dto.getCode(), dto.getIsStrike(), null);
        return service.update(code, subjectCode, section, dto.getSubjectCode());
    }

    @DeleteMapping("/{subjectCode}/{code}")
    public void delete(@PathVariable String subjectCode, @PathVariable String code) {
        service.delete(code, subjectCode);
    }
}
