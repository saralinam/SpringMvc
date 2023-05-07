package com.tpe.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_student")
public class Student {//student

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id; //0
    @NotBlank(message = "Please Provide valid first Name ")//@NotBlank =not empty("") ,not null ,not blank(" ")
    private String firstName;

    @NotEmpty(message = "Please Provide valid last Name ")//   @NotEmpty =not empty("") ,not null
    private String lastName;

    @NotNull(message = "Please Provide valid grade")//  @NotNull = not null
    private Integer grade;

    private LocalDateTime createDate= LocalDateTime.now();
    //getter and setter


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }



    //toString Method

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", createDate=" + createDate +
                '}';
    }
}
