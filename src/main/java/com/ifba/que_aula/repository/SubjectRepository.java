package com.ifba.que_aula.repository;

import com.ifba.que_aula.models.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}
