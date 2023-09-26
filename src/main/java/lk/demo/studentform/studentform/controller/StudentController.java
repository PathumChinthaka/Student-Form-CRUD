package lk.demo.studentform.studentform.controller;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.entity.Student;
import lk.demo.studentform.studentform.persistence.StudentRepository;
import lk.demo.studentform.studentform.service.StudentService;
import lk.demo.studentform.studentform.util.ResponseUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public StudentDTO saveStudentData(@RequestBody StudentDTO studentObj){
        if(studentObj==null){
            System.out.println("Student Object is null");
        }else {
            System.out.println(studentObj);
            studentService.saveStudent(studentObj);
        }
        return studentObj;
    }

    @GetMapping("/get")
    public List<Student> getStudentData(){
        return studentService.getAllData();
    }

    @PutMapping("/update")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseUtil updateStudent(@RequestBody StudentDTO studentDTO){
        studentService.updateData(studentDTO);
        return new ResponseUtil(200,"Student data updated");
    }

    @DeleteMapping("/delete")
    public ResponseUtil deleteStudent(@RequestBody StudentDTO studentDTO){
        studentService.deleteData(studentDTO);
        return new ResponseUtil(200,"Student data deleted");
    }

}
