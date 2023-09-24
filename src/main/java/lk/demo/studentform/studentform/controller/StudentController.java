package lk.demo.studentform.studentform.controller;

import lk.demo.studentform.studentform.dto.StudentDTO;
import lk.demo.studentform.studentform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:5500/"})
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public StudentDTO saveStudentData(@RequestBody StudentDTO studentObj){
        if(studentObj==null){
            System.out.println("Student Object is null");
        }else {
            studentService.saveStudent(studentObj);
        }
        return studentObj;
    }

    @GetMapping("/hi")
    public String getStudentData(){
        System.out.println("mama awaa");
        return "Mama awa ban";

    }

}
