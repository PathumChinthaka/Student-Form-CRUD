package lk.demo.studentform.studentform.service.impl;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        return null;
    }
}
