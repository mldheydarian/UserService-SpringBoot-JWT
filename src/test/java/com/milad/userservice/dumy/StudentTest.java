package com.milad.userservice.dumy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest {

    Address address1=new Address("N-Shahin");
    Student studen1t=new Student(address1);
    @Test
    void writeTest1() {
        address1.setStreet("N-Shahin");
        Student student = new Student(address1);
        assertEquals("live in N-Shahin", student.write());
    }


    @Autowired
    Address address2;
    @Test
    void writeTest2() {
        address2.setStreet("N-Shahin");
        Student student2 = new Student(address2);
        assertEquals("live in N-Shahin", student2.write());
    }


    @Autowired
    Address address3;
    @Autowired
    Student student3;
    @Test
    void writeTest3() {
        address3.setStreet("N-Shahin");
      //khode spring mifahme va automaric address ro inject mijone
       // student3.setAddress(address3);
        assertEquals("live in N-Shahin", student3.write());
    }

    @Mock
    Address address4;
    @InjectMocks
    Student student4;
    @Test
    void writeTest4() {
        address4.setStreet("N-Shahin");

        student4.setAddress(address4);
        assertEquals("live in N-Shahin", student4.write());
    }

    @Mock
    Address address5;
    @InjectMocks
    Student student5;
    @Test
    void writeTest5() {
       Mockito.when(address5.getStreet()).thenReturn("N-Shahin");
        assertEquals("live in N-Shahin", student5.write());
    }


}
