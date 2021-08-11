package Homework01.client;

import Homework01.controller.StudentController;
import Homework01.models.Course;
import Homework01.models.Instructor;
import Homework01.models.PermanentInstructor;
import Homework01.models.Student;
import Homework01.service.StudentService;
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
        PermanentInstructor permanentInstructor = new PermanentInstructor("Mustafa Rabuş", "Ankara", "5554443322", courseList, 7000);
        Course course = new Course("Fizik", "FİZ-1", 6, permanentInstructor);


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
        student.setName("Mehmet");

        //Student Saving Controller
        saveData(student);
        //Student Get Data Controller
        System.out.println(getData(1).toString());
        //Updating Controller
        updateData(student, 1);
        //Deleting Controller
        deleteData(1);


    }


    public static void saveData(Student student) {

        StudentController studentController = new StudentController();


        studentController.saveStudent(student);
    }

    public static Student getData(int id) {
        StudentController studentController = new StudentController();

        Student student = studentController.getStudent(id);

        return student;

    }

    public static String deleteData(int id) {
        StudentController studentController = new StudentController();

        studentController.deleteStudent(id);

        return "Deletion Successful";
    }

    public static String updateData(Student student, int id) {
        StudentController studentController = new StudentController();

        studentController.updateStudent(student, id);

        return "Update Successful";
    }


}
