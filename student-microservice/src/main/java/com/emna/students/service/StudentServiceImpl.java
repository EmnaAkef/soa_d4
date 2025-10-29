package com.emna.students.service;


import com.emna.students.dto.APIResponseDto;
import com.emna.students.dto.SectionDto;
import com.emna.students.dto.StudentDto;
import com.emna.students.entities.Student;
import com.emna.students.repos.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public APIResponseDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();

//        SectionDto sectionDto = webClient.get()
//                .uri("http://localhost:8080/api/sections/" +
//                        student.getSecCode())
//                .retrieve()
//                .bodyToMono(SectionDto.class)
//                .block();
        SectionDto sectionDto = apiClient.getSecByCode(student.getSecCode());

        StudentDto studentDto =  new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getSecCode(),
                sectionDto.getSecName()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setStudentDto(studentDto);
        apiResponseDto.setSectionDto(sectionDto);

        return apiResponseDto;
    }
}
