package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Course;
import edu.icet.crm.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    public List<Course> getCourse(){
        List<Course> courseArrayList = new ArrayList<>();
        courseArrayList.add(new Course("105","ICM","8"));
        return courseArrayList;
    }


}
