package edu.icet.crm.Controller;
import edu.icet.crm.dto.Response;
import edu.icet.crm.dto.Student;
import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.service.StudentSerivece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/student/{studentId}")
    Response removeStudent(@PathVariable Long studentId){
        boolean isRemoved = studentSerivece.removeStudent(studentId);
        if(isRemoved){
            return new Response("Removed Student");
        }else{
            return new Response("unsuccess");
        }
    }
}
