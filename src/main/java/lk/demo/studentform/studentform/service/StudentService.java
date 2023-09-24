package lk.demo.studentform.studentform.service;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.entity.Student;

import java.util.List;

public interface StudentService {
     StudentDTO saveStudent(StudentDTO studentDTO);
     List<Student>getAllData();
}
