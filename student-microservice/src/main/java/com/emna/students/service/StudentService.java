package com.emna.students.service;

import com.emna.students.dto.APIResponseDto;
import com.emna.students.dto.StudentDto;

public interface StudentService {
    APIResponseDto getStudentById(Long id);
}
