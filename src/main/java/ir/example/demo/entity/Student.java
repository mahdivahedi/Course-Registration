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
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "national_id")
    private long nationalId;

    private int age;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable(name = "student_master", inverseJoinColumns = @JoinColumn(name = "master_id"), joinColumns = @JoinColumn(name = "student_id"))
    private List<Master> masters = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable(name = "student_course", inverseJoinColumns = @JoinColumn(name = "course_id"), joinColumns = @JoinColumn(name = "student_id"))
    private List<Course> courses = new ArrayList<>();


    public String toString() {
        return getName() + " - " + getMasters().get(0).getName() + " - " + getCourses().get(0).getName() + " - " + getAge() + " - " + getId();
    }

}
