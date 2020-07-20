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
@Table(name = "master")
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable(name = "master_course", inverseJoinColumns = @JoinColumn(name = "course_id"), joinColumns = @JoinColumn(name = "master_id"))
    private List<Course> courses = new ArrayList<>();

    @ManyToMany(mappedBy = "masters")
    private List<Student> students = new ArrayList<>();

}
