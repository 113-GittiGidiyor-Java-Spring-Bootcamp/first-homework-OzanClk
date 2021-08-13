package Homework01.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private String courseCode;
    private int courseCredit;


    @ManyToOne
    private Instructor instructor;

    @ManyToMany(mappedBy = "studentCourseList")
    private List<Student> studentList;


    public Course(String courseName, String courseCode, int courseCredit, Instructor instructor) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.instructor = instructor;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
