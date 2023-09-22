package lk.demo.studentform.studentform.controller;

import lk.demo.studentform.studentform.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:5500/"})
public class StudentController {

    @PostMapping("/save")
    public StudentDTO saveStudentData(@RequestBody StudentDTO studentObj){
        System.out.println(studentObj);
        return studentObj;
    }

    @GetMapping("/hi")
    public String getStudentData(){
        System.out.println("mama awaa");
        return "Mama awa ban";

    }

}
