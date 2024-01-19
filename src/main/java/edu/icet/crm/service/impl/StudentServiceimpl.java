package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Student;
import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.repository.StudentRepository;
import edu.icet.crm.service.StudentSerivece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceimpl implements StudentSerivece {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ObjectMapper mapper;
    public StudentEntity createStudent(Student student){
        StudentEntity studentEntity = mapper.convertValue(student, StudentEntity.class);
        return studentRepository.save(studentEntity);
    }

    @Override
    public List<Student> retriveStudent() {
        Iterable<StudentEntity> studentRepositoryAll = studentRepository.findAll();
        List<Student> studentList  = new ArrayList<>();
        for(StudentEntity student:studentRepositoryAll){
            studentList.add(
                    new Student(
                            student.getFirstName(),
                            student.getLastName(),
                            student.getContactNumber()
                    )
            );
        }
        return studentList;
    }
}
