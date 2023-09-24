package lk.demo.studentform.studentform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("Student")
public class Student implements SuperEntity {
    @Id
    private String sid;
    private String name;
    private String city;
    private String email;
    private String level;
}
