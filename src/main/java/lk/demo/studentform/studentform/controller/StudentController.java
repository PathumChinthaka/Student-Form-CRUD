package lk.demo.studentform.studentform.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {""})
public class StudentController {

    @GetMapping
    public String getStudentData(){
        return "Hi There";
    }

}
