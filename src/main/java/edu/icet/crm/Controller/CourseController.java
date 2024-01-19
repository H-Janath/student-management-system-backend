package edu.icet.crm.Controller;

import edu.icet.crm.dto.Course;
import edu.icet.crm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/getCourse")
    List<Course> getCourss(){
        return courseService.getCourse();
    }
}
