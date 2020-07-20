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
    private List<Master> masters = new ArrayList<>();


    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();


    @OneToMany(mappedBy = "course")
    private List<Semester> semesters;

    public String toString() {
        return "id is: " + id + "\n name of course is: " + name + "\n in one semester like: " + semesters.get(0).getTime() + "";
    }

}
