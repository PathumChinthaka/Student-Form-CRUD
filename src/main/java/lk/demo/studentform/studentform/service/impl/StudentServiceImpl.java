package lk.demo.studentform.studentform.service.impl;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.entity.Student;
import lk.demo.studentform.studentform.persistence.StudentRepository;
import lk.demo.studentform.studentform.service.StudentService;
import lk.demo.studentform.studentform.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    Converter converter;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student=converter.getStudentEntity(studentDTO);
        studentRepository.save(student);
        return studentDTO;
    }

    @Override
    public List<Student> getAllData() {
        return studentRepository.findAll();
    }

    @Override
    public void updateData(StudentDTO studentDTO) {
       if(studentRepository.existsById(studentDTO.getSid())){
           studentRepository.save(converter.getStudentEntity(studentDTO));
       }else {
           System.out.println("not ok");
       }
    }
}
