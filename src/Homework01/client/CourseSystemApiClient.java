package Homework01.client;

import Homework01.controller.StudentController;
import Homework01.models.Course;
import Homework01.models.Instructor;
import Homework01.models.PermanentInstructor;
import Homework01.models.Student;
import Homework01.util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseSystemApiClient {

    public static void main(String[] args) {

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        StudentController studentController = new StudentController();
        List<Course> courseList = new ArrayList<>();
        PermanentInstructor permanentInstructor = new PermanentInstructor("Hakan Kaya", "Ankara", "5554443322", courseList, 5000);
        Course course = new Course("Matematik", "MAT-1", 6, permanentInstructor);


        try {
            em.getTransaction().begin();

            em.persist(course);
            em.persist(permanentInstructor);

            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

        courseList.add(course);

        Student student = new Student("Ozan", LocalDate.now(), "Istanbul", "Male", courseList);


        studentController.saveCustomer(student);


    }

}
