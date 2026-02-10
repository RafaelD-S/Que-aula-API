package com.ifba.que_aula.service;

import com.ifba.que_aula.exception.ResourceNotFoundException;
import com.ifba.que_aula.models.entities.Course;
import com.ifba.que_aula.models.entities.Section;
import com.ifba.que_aula.repository.CourseRepository;
import com.ifba.que_aula.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final SectionRepository sectionRepository;

    public CourseService(CourseRepository courseRepository, SectionRepository sectionRepository) {
        this.courseRepository = courseRepository;
        this.sectionRepository = sectionRepository;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course não encontrado: " + id));
    }

    public Course create(Course course, String sectionCode) {
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new ResourceNotFoundException("Section não encontrada: " + sectionCode));
        course.setSection(section);
        return courseRepository.save(course);
    }

    public Course update(Long id, Course courseDetails, String sectionCode) {
        Course course = findById(id);
        Section section = sectionRepository.findById(sectionCode)
                .orElseThrow(() -> new ResourceNotFoundException("Section não encontrada: " + sectionCode));

        course.setSection(section);
        course.setTeacher(courseDetails.getTeacher());
        course.setClassroom(courseDetails.getClassroom());
        course.setWeekday(courseDetails.getWeekday());
        course.setPeriod(courseDetails.getPeriod());

        return courseRepository.save(course);
    }

    public void delete(Long id) {
        Course course = findById(id);
        courseRepository.delete(course);
    }
}
