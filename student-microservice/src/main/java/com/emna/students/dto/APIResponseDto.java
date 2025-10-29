package com.emna.students.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private StudentDto studentDto;
    private SectionDto sectionDto;
}
