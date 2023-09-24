package lk.demo.studentform.studentform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String sid;
    private String name;
    private String city;
    private String email;
    private String level;
}
