package com.emna.section;

import com.emna.section.entities.Section;
import com.emna.section.repos.SectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SectionMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SectionMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(SectionRepository sectionRepository) {
        return args -> {
            sectionRepository.save(Section.builder()
                    .secName("Informatique")
                    .secCode("INFO")
                    .build());
            sectionRepository.save(Section.builder()
                    .secName("Génie Civil")
                    .secCode("GCIV")
                    .build());
        };
    }
}
