package com.emna.students.service;

import com.emna.students.dto.SectionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//@FeignClient(url = "http://localhost:8080", value = "SECTION")
@FeignClient(name = "SECTION-MICROSERVICE")
public interface APIClient {
        @GetMapping("api/sections/{section-code}")
        SectionDto getSecByCode(@PathVariable("section-code") String sectionCode
        );
}
