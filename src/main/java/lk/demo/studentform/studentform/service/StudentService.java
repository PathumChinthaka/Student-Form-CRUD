package lk.demo.studentform.studentform.service;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
     StudentDTO saveStudent(StudentDTO studentDTO);
     List<Student>getAllData();
     void updateData(StudentDTO studentDTO);
     void deleteData(StudentDTO studentDTO);
     List<Student> findStudentData(String sid);
}
