package com.ifba.que_aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifba.que_aula.models.entities.Section;
import com.ifba.que_aula.models.entities.SectionId;

public interface SectionRepository extends JpaRepository<Section, SectionId> {
}
