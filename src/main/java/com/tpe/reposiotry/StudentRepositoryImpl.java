package com.tpe.reposiotry;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Repository//to indicate that class is repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession(); //used to create new instance as we needed.
        Transaction transaction = session.beginTransaction();

        List<Student> studentList = session.createQuery("FROM Student", Student.class).getResultList();

        transaction.commit();
        ;
        session.close();
        //sessionFactory.close();; //because the life cycle handel by Bean
        return studentList;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.openSession(); //used to create new instance as we needed.
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);

        transaction.commit();
        ;
        session.close();
        return Optional.ofNullable(student);   //this student maybe null also, if it is
        // null, it will return empty obj
    }

    @Override
    public void save(Student student) {

        Session session = sessionFactory.openSession(); //used to create new instance as we needed.
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(student);////If the object does not have an identifier,
        // Hibernate will insert a new row into the database.
        //If the object does  have an identifier, Hibernate will update the record

        transaction.commit();
        ;
        session.close();
        //sessionFactory.close();; //because the life cycle handel by Bean

    }

    @Override
    public void delete(Long id) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Student student = session.get(Student.class, id);
            session.delete(student);

            transaction.commit();
            session.close();



    }
}