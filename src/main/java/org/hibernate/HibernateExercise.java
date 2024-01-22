package org.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateExercise {
    static SessionFactory factory;

    // Main
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        factory = cfg.buildSessionFactory();

        // Add
        insertStudent("Antonio","Martinez","antonio@email.com","971112312");
        insertStudent("Diego","Martinez","diego@email.com","971888828");
        insertStudent("Lucas","Rodriguez","lucas@email.com","971822827");
        insertStudent("Manolo","Iglesias","manolo@email.com","971888821");

        // Update
        updateStudent(1,"Change name","Martinez","antonio@email.com","971112312");

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
    private static void insertStudent(String nombre, String lastname, String email,String phone) {
		// Add code here
    }

    // Update a student
    private static void updateStudent(int id,String nombre, String lastname, String email,String phone) {

        // Add code here

    }

    // Delete a student
    private static void deleteStudent(int id) {

        // Add code here

    }

    // Get one student by id
    private static Student getStudent(int id) {
        // Add code here
        return null;
    }

    // Get all students
    private static List<Student> listStudents() {

        List<Student> empty=new ArrayList();

        // Add code here

        return empty;
    }
}