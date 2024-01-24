package org.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class HibernateExercise {
    static SessionFactory factory;

    // Main
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();

        // Add
        insertStudent("Antonio","Martinez","antonio@email.com","971112312", 12);
        insertStudent("Diego","Martinez","diego@email.com","971888828", 13);
        insertStudent("Lucas","Rodriguez","lucas@email.com","971822827", 14);
        insertStudent("Manolo","Iglesias","manolo@email.com","971888821", 15);

        // Update
        updateStudent(1,"Change name","Martinez","antonio@email.com","971112312", 50);

        // Delete
        deleteStudent(2);

        // Get one item
        System.out.println("Get name of student 1: "+getStudent(1).getName());

        // Print all students
        System.out.println("Students..............: ");
        for (Student student:listStudents()) {
            System.out.println(student.getId()+" : "+student.getName());
        }

        // Close and finish
        factory.close();
    }

    // Insert a student
    private static void insertStudent(String nombre, String lastname, String email,String phone, int age) {
		// Add code here
        Session session = factory.openSession();
        Student student = new Student(nombre, lastname, email, phone, age);
        session.save(student);
        session.close();
    }

    // Update a student
    private static void updateStudent(int id,String nombre, String lastname, String email,String phone, int age) {
        // Add code here
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            student.setName(nombre);
            student.setLastname(lastname);
            student.setEmail(email);
            student.setPhone(phone);
            student.setAge(age);
            session.update(student);
            tx.commit();
        }catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    // Delete a student
    private static void deleteStudent(int id) {
        // Add code here
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Student student = (Student) session.get(Student.class, id);
            session.delete(student);
            tx.commit();
        }catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    // Get one student by id
    private static Student getStudent(int id) {
        // Add code here
        Session session = factory.openSession();
        Student student = (Student) session.get(Student.class, id);
        session.close();
        return student;
    }

    // Get all students
    private static List<Student> listStudents() {

        List<Student> studentList=new ArrayList();

        // Add code here
        Session session = factory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
        criteria.from(Student.class);
        studentList = session.createQuery(criteria).getResultList();
        session.close();

        return studentList;
    }
}