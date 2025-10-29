package com.emna.section.repos;

import com.emna.section.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,
        Long> {
    Section findBySecCode(String code);
}
