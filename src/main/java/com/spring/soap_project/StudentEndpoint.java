package com.spring.soap_project;

import com.spring.soap_project.student.GetResponse;
import com.spring.soap_project.student.GetStudent;
import com.spring.soap_project.student.Student;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class StudentEndpoint {

    private StudentServis studentServis;

    public StudentEndpoint(StudentServis studentServis) {
        this.studentServis = studentServis;
    }

    @PayloadRoot(namespace = "http://spring/soap-example", localPart = "getStudent")
    @ResponsePayload
    public GetResponse getStudentById(@RequestPayload GetStudent getStudent) {
        Student studentsById = studentServis.getStudentsById(getStudent.getId());;
        GetResponse getResponse = new GetResponse();
        getResponse.setStudent(studentsById);
        return getResponse;
    }
}
