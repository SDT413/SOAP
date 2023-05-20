package com.spring.soap_project;

import org.springframework.stereotype.Service;
import com.spring.soap_project.student.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServis {

    private List<Student> students;

    public Student getStudentsById(long id) {
        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst().get();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentServis() {
        students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("John");
        student1.setSurname("Doe");
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Jane");
        student2.setSurname("Doe");
        students.add(student1);
        students.add(student2);
    }
}
