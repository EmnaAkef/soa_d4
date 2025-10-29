package com.emna.students;

import com.emna.students.entities.Student;
import com.emna.students.repos.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableFeignClients
@SpringBootApplication
public class StudentMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMicroserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            studentRepository.save(Student.builder()
                    .firstName("Emna")
                    .lastName("Akef")
                    .secCode("INFO")
                    .build());

        };
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

}
