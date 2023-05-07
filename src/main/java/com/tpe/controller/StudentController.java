package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

//@Component
@Controller
@RequestMapping("/students")////http://localhost:8080/SpringMVC/students
////This annotation is used to map HTTP requests to specific methods in a controller
//The @RequestMapping annotation can be applied at both the class and method level in Spring.
//@RestController// this annotation that combine  @Controller and  @responseBody

//class level to define a default mapping for all methods in the class,
// Method  level :specifies the URI path and HTTP method for handling a specific Method.

public class StudentController {

    @Autowired
    private StudentService service;


    @GetMapping("/hi")////http://localhost:8080/SpringMVC/students/hi+get
    //@GetMapping that handles HTTP GET requests with a URI path of "/hi".
    public ModelAndView sayHi(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Hello ,");
        mav.addObject("messagebody","I am A students Management System");
        mav.setViewName("hi");//hi.jsp;
        return mav;//model and view
    }

    //1-create Students
    //ModelAttribute: ModelAttribute is used to bind request parameters to a model object.
    //@ModelAttribute :This is done to provide a reference of the Student object to the view
    // so that the view can bind form data to the Student object.

    @GetMapping("/new")////http://localhost:8080/SpringMVC/students/new+get
    public String sentStudentForm(@ModelAttribute("student") Student student){

        return "studentForm";

        //@ModelAttribute--used to bind data from view file to model
    }

    //@PostMapping - This annotation is used to map HTTP POST requests to a specific method in the controller class.
//    @PostMapping("/saveStudent")//http://localhost:8080/SpringMvc/students/saveStudent
//    public String createStudent(@Valid @ModelAttribute Student student){
//        service.saveStudent(student);
//        return "redirect:/students";
//    }

    //post method which will display entity error message
    @PostMapping("/saveStudent")//http://localhost:8080/SpringMvc/students/saveStudent
    public String createStudent(@Valid @ModelAttribute Student student, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "studentForm";
        }

        service.saveStudent(student);
        return "redirect:/students";  //http://localhost:8080/SpringMVC/students
    }


    //2-display all students
    @GetMapping()   //http://localhost:8080/SpringMVC/students
    public ModelAndView getStudentList(){
        List<Student> list =service.getAll(); //list holds all students information
        ModelAndView mav = new ModelAndView();
        mav.addObject("studentList", list); //binded list to studentList in students.jsp
        mav.setViewName("students"); //students.jsp
        return mav;
    }

    //3 - update  student
    @GetMapping("/update") //http://localhost:8080/SpringMvc/students/update?id=1
    public ModelAndView showFormPageToUpdate(@RequestParam("id") Long id){

        Student foundStudent =  service.getStudentById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("student", foundStudent);
        mav.setViewName("studentForm");
        return mav;

    }

    //4 - Delete Student

    @GetMapping("/delete/{id}") //http://localhost:8080/SpringMvc/students/delete/1
    public String deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return "redirect:/students";
    }

    //5- Exception Handling

    @ExceptionHandler (ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFoundException(Exception ex){
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", ex.getMessage());
        mav.setViewName("notFound");
        return mav;
    }

    //to return Restful API

    @GetMapping("/allStudents") //http://localhost:8080/SpringMvc/students/allStudents
    @ResponseBody
    public List<Student> getAllStudentsInJSON(){
        return service.getAll();
    }


}
