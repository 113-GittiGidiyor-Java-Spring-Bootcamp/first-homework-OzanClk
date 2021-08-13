package Homework01.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String instructorName;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    private List<Course> instructorCourseList;

    public Instructor(String instructorName, String address, String phoneNumber, List<Course> courseList) {
        this.instructorName = instructorName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.instructorCourseList = courseList;
    }

    public Instructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return instructorCourseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.instructorCourseList = courseList;
    }
}
