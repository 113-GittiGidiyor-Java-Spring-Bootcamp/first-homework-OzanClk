package Homework01.client;

import Homework01.controller.StudentController;
import Homework01.models.*;
import Homework01.service.StudentService;
import Homework01.util.EntityManagerUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.transform.Scale;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CourseSystemApiClient {


    public static void main(String[] args) {


        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        //Objects created for registration in the database

        StudentController studentController = new StudentController();

        //Course List for Instructor and Students
        List<Course> permanentInstructorCourseList = new ArrayList<>();
        List<Course> visitingInstructorCourseList = new ArrayList<>();
        List<Course> studentCourseList = new ArrayList<>();

        //Instructors Objects
        PermanentInstructor permanentInstructor = new PermanentInstructor("Mustafa Rabus", "Ankara", "5554443322", permanentInstructorCourseList, 7000);
        Instructor visitingInstructor = new VisitingInstructor("Yasin Caliskan", "Istanbul", "5553332211", visitingInstructorCourseList, 200);

        //Courses Objects
        Course course1 = new Course("Fizik", "FIZ-1", 6, permanentInstructor);
        Course course2 = new Course("Kimya", "KIM-1", 5, visitingInstructor);


        //Registration of objects other than student object to the database
        try {
            em.getTransaction().begin();

            em.persist(course1);
            em.persist(permanentInstructor);
            em.persist(course2);
            em.persist(visitingInstructor);


            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

        //Added Student to Course List
        studentCourseList.add(course1);

        //Student Object
        Student student = new Student("Ozan", LocalDate.now(), "Istanbul", "Male", studentCourseList);

        //CRUD operations

        while (true) {
            System.out.println("Press 1 for enroll student");
            System.out.println("Press 2 for get information student");
            System.out.println("Press 3 for update information student");
            System.out.println("Press 4 for delete information student");
            System.out.println("Press 5 for exit");
            Scanner scan = new Scanner(System.in);
            int key = scan.nextInt();
            scan.nextLine();

            switch (key) {
                case 1:
                    //Student Saving Controller
                    saveData(student);
                    break;
                case 2:
                    //Student Get Data Controller
                    System.out.println(getData(1).toString());
                    break;
                case 3:
                    //Updating Controller
                    student.setName("Mehmet");
                    updateData(student, 3);
                case 4:
                    //Deleting Controller
                    deleteData(1);
                default:
                    break;

            }
            if (key == 5)
                break;

        }
        System.out.println("Crud Operations Terminated");


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
