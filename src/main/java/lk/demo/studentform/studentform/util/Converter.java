package lk.demo.studentform.studentform.util;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    @Autowired
   private ModelMapper modelMapper;

    public Converter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StudentDTO getStudentDTO(Student student){
        return modelMapper.map(student,StudentDTO.class);
    }

    public Student getStudentEntity(StudentDTO studentDTO){
        return modelMapper.map(studentDTO,Student.class);
    }
}
