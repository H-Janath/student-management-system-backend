package edu.icet.crm.service;

import edu.icet.crm.dto.Student;
import edu.icet.crm.entity.StudentEntity;

import java.util.List;

public interface StudentSerivece {
    StudentEntity createStudent(Student student);

    List<Student> retriveStudent();
    public boolean removeStudent(Long studentId);
}
