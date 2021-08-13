package Homework01.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class PermanentInstructor extends Instructor {

    private double monthlySalary;

    public PermanentInstructor(String instructorName, String address, String phoneNumber, List<Course> courseList, double monthlySalary) {
        super(instructorName, address, phoneNumber, courseList);
        this.monthlySalary = monthlySalary;
    }

    public PermanentInstructor(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public PermanentInstructor() {

    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
