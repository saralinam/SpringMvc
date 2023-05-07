package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.reposiotry.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
@Service
//marks a class as a service provider in the business logic layer
//In general, a service class is responsible for implementing the business logic of the application
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;
    @Override
    public void saveStudent(Student student) {

        repository.save(student);
    }

    @Override
    public List<Student> getAll() {
//       List<Student> studentList= repository.findAll();
//       return studentList;
        return repository.findAll();
    }



    @Override
    public Student getStudentById(Long id) {
        Student student = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student object not found with id: "+id ));
        return student;
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);
        repository.delete(student.getId());

    }
}

