package Homework01.service;

import Homework01.models.Student;
import Homework01.repository.CrudRepository;
import Homework01.repository.StudentRepository;
import Homework01.util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");


    @Override
    public List<Student> findAll() {

        return em.createQuery("from Student ", Student.class).getResultList();

    }

    @Override
    public Student findById(int id) {

        return em.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }

    @Override
    public void deleteFromDatabase(Student student) {
        try {
            em.getTransaction().begin();

            Student findStudent = em.createQuery("from Student s WHERE s.id =:id", Student.class).setParameter("id", student.getId()).getSingleResult();
            em.remove(findStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(int id) {

        try {
            em.getTransaction().begin();

            Student findStudent = em.find(Student.class, id);
            em.remove(findStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }

    @Override
    public void updateOnDatabase(Student object, int id) {

    }


    @Override
    public void deleteCustomerFromDatabase(long ssid) {

    }
}
