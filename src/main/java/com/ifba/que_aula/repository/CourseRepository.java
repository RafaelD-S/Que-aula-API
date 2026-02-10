package com.ifba.que_aula.repository;

import com.ifba.que_aula.models.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
