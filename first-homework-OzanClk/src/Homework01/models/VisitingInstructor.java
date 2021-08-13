package Homework01.models;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
public class VisitingInstructor extends Instructor {

    private double hourlySalary;

    public VisitingInstructor(String instructorName, String address, String phoneNumber, List<Course> courseList, double hourlySalary) {
        super(instructorName, address, phoneNumber, courseList);
        this.hourlySalary = hourlySalary;
    }

    public VisitingInstructor(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingInstructor() {
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }


}
