package lk.demo.studentform.studentform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private String city;
    private String email;
    private String level;
}
