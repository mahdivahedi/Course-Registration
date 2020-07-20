/*
package ir.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "semester_id")
    private int semesterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    private String time;

}
*/
