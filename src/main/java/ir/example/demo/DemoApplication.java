package ir.example.demo;

import ir.example.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }

    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Master.class).addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class);

        // create a session
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner input = new Scanner(System.in);

        try {
            session.beginTransaction();

            int studentId = input.nextInt();
            List<Course> courses = new ArrayList<>();

            try {
                courses.addAll(session.find(Student.class, studentId).getCourses());
            } catch (Exception e){
                e.printStackTrace();
            }

            courses.forEach(c ->
                    System.out.println("this course: " + c.getName() + " offered by : " + c.getStudents().get(0) + " student"));

            /*
            do logic stuff
             */

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }

    }

}
