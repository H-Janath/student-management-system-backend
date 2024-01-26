package edu.icet.crm.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student{
    private String id;
    private String firstName;
    private String lastName;
    private String contactNumber;
}