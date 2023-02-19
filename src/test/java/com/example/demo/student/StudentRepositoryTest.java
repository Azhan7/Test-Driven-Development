package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @Test
    void itShouldCheckIfStudentEmailExists() {
        //Given
        String email = "azhan@gmail.com";
        Student student = new Student(
                "Azhan", "azhan@gmail.com", Gender.FEMALE
        );
        underTest.save(student);
        //When
        boolean exists = underTest.selectExistsEmail(email);
        //Then
        assertThat(exists).isTrue();

    }


    @Test
    void itShouldCheckIfStudentDoesNotEmailExists() {
        //Given
        String email = "azhan123@gmail.com";
        //When
        boolean exists = underTest.selectExistsEmail(email);
        //Then
        assertThat(exists).isFalse();

    }
}
