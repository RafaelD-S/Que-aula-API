package com.ifba.que_aula.repository;

import com.ifba.que_aula.models.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {
}
