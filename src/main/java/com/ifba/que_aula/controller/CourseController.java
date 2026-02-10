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

import com.ifba.que_aula.dto.CourseDTO;
import com.ifba.que_aula.dto.CourseResponseDTO;
import com.ifba.que_aula.models.entities.Course;
import com.ifba.que_aula.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseResponseDTO> getAll() {
        return service.findAll().stream()
            .map(s -> new CourseResponseDTO (
                s.getIdCourse(),
                s.getSection().getCode(),
                s.getTeacher(),
                s.getClassroom(),
                s.getWeekday(),
                s.getPeriod()
        )).toList();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Course create(@Valid @RequestBody CourseDTO dto) {
        Course course = new Course(
                null,
                dto.getTeacher(),
                dto.getClassroom(),
                dto.getWeekday(),
                dto.getPeriod()
        );

        return service.create(course, dto.getSectionCode());
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @Valid @RequestBody CourseDTO dto) {

        Course course = new Course(
                null,
                dto.getTeacher(),
                dto.getClassroom(),
                dto.getWeekday(),
                dto.getPeriod()
        );

        return service.update(id, course, dto.getSectionCode());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
