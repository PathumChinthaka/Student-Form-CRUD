package lk.demo.studentform.studentform.persistence;

import lk.demo.studentform.studentform.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,String> {
    Student save(Student student);
}
