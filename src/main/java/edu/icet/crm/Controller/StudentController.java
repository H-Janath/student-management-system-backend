package edu.icet.crm.Controller;
import edu.icet.crm.dto.Student;
import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.service.StudentSerivece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    @Autowired
    StudentSerivece studentSerivece;
    @PostMapping("/student")
    public StudentEntity ceateStudent(@RequestBody Student student){
       return studentSerivece.createStudent(student);
    }
    @GetMapping("/student")
    List<Student> getStudent(){
        return studentSerivece.retriveStudent();
    }
}
