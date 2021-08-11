package Homework01.controller;


import Homework01.models.Student;
import Homework01.service.StudentService;

public class StudentController {

    private StudentService studentService = new StudentService();

    public void saveCustomer(Student student) {
        studentService.saveToDatabase(student);
    }


}
