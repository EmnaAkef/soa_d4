package com.emna.section.service;


import com.emna.section.dto.SectionDto;
import com.emna.section.entities.Section;
import com.emna.section.repos.SectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SectionServiceImpl  implements SectionService{

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public SectionDto getSectionByCode(String code) {
        Section sec = sectionRepository.findBySecCode(code);
        SectionDto sectionDto = new SectionDto(
                sec.getId(),
                sec.getSecName(),
                sec.getSecCode()
        );
        return sectionDto;
    }
}
