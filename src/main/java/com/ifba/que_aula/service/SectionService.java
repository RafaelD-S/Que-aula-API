package com.ifba.que_aula.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifba.que_aula.exception.ResourceNotFoundException;
import com.ifba.que_aula.models.entities.Section;
import com.ifba.que_aula.models.entities.Subject;
import com.ifba.que_aula.repository.SectionRepository;
import com.ifba.que_aula.repository.SubjectRepository;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;

    public SectionService(SectionRepository sectionRepository, SubjectRepository subjectRepository) {
        this.sectionRepository = sectionRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section findById(String code) {
        return sectionRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Section não encontrada: " + code));
    }

    public Section create(Section section, String subjectCode) {
        Subject subject = subjectRepository.findById(subjectCode)
                .orElseThrow(() -> new ResourceNotFoundException("Subject não encontrado: " + subjectCode));
        section.setSubject(subject);
        return sectionRepository.save(section);
    }

    public Section update(String code, Section sectionDetails, String subjectCode) {
        Section section = findById(code);
        section.setIsStrike(sectionDetails.getIsStrike());
        Subject subject = subjectRepository.findById(subjectCode)
                .orElseThrow(() -> new ResourceNotFoundException("Subject não encontrado: " + subjectCode));
        section.setSubject(subject);
        return sectionRepository.save(section);
    }

    public void delete(String code) {
        Section section = findById(code);
        sectionRepository.delete(section);
    }
}
