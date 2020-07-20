package ir.example.demo.data;

import ir.example.demo.entity.Course;
import ir.example.demo.entity.Master;
import org.springframework.data.repository.CrudRepository;


public interface CourseRepository extends CrudRepository<Course, Integer> {

    Course findByMastersContaining (Master master);
}
