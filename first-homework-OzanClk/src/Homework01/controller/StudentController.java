package Homework01.controller;


import Homework01.models.Student;
import Homework01.service.StudentService;

public class StudentController {

    private StudentService studentService = new StudentService();

    public void saveStudent(Student student) {
        studentService.saveToDatabase(student);
    }

    public Student getStudent(int id) {
        return studentService.findById(id);
    }

    public void updateStudent(Student student, int id) {
        studentService.updateOnDatabase(student, id);
    }

    public void deleteStudent(int id) {
        studentService.deleteFromDatabase(id);
    }


}
