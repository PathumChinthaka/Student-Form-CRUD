package lk.demo.studentform.studentform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String name;
    private String city;
    private String email;
    private String level;
}
