package lk.demo.studentform.studentform.persistence;

import lk.demo.studentform.studentform.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDAO extends CrudRepository<Student,String> {
}
