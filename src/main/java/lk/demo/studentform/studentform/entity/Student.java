package lk.demo.studentform.studentform.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("Student")
public class Student implements SuperEntity {
    @Id
    @NotNull(message = "Id is important")
    private String sid;
    @NotEmpty(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "City is mandatory")
    private String city;
    @Email(message = "Email is mandatory")
    private String email;
    @NotEmpty
    private String level;
}
