package com.emna.section.restControllers;


import com.emna.section.config.Configuration;
import com.emna.section.dto.SectionDto;
import com.emna.section.service.SectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    Configuration configuration;
    @Value("${build.version}")
    private String buildVersion;

    public SectionController(SectionService sectionService){
        this.sectionService = sectionService;
    }

    private SectionService sectionService;

    @GetMapping("{code}")
    public ResponseEntity<SectionDto> getSecByCode(@PathVariable("code")
                                                      String code )
    {
        return  new ResponseEntity<SectionDto>(
                sectionService.getSectionByCode(code),
                HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version()
    {
        return
                ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public  ResponseEntity<String> retrieveAuthorInfo() {
        return
                ResponseEntity.status(HttpStatus.OK)
                        .body(configuration.getName()+" "+configuration.getEmail() );
    }
}
