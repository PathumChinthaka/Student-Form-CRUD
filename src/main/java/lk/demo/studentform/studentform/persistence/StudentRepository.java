package lk.demo.studentform.studentform.persistence;

import lk.demo.studentform.studentform.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    Student save(Student student);
    List<Student> findAll();
}
