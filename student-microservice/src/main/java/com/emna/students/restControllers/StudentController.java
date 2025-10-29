package com.emna.students.restControllers;


import com.emna.students.dto.APIResponseDto;
import com.emna.students.dto.StudentDto;
import com.emna.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {
    private StudentService StudentService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getStudentById(@PathVariable("id")
                                                     Long id )
    {
        return  new ResponseEntity<APIResponseDto>(
                StudentService.getStudentById(id), HttpStatus.OK);
    }
}
