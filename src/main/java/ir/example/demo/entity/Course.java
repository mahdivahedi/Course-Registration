package ir.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    @ManyToMany(mappedBy = "courses")
//    @JoinTable(name = "master_course", inverseJoinColumns = @JoinColumn(name = "course_id"), joinColumns = @JoinColumn(name = "master_id"))
    private List<Master> masters = new ArrayList<>();


    @ManyToMany(mappedBy = "courses")
//    @JoinTable(name = "student_course", inverseJoinColumns = @JoinColumn(name = "course_id"), joinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();


    /*@OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "semester")
    private List<Semester> semesters;*/

}
