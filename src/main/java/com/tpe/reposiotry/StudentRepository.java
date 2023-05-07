package com.tpe.reposiotry;

import com.tpe.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {


    List<Student> findAll();

    Optional<Student> findById(Long id);////to avoid NullPointer exception return  null//Optional{ali}
    //If it does not find one, it will return an empty Optional object.

    void save(Student student);
    void delete(Long id);

}
