package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Student;
import edu.icet.crm.entity.StudentEntity;
import edu.icet.crm.repository.StudentNativeRepository;
import edu.icet.crm.repository.StudentRepository;
import edu.icet.crm.service.StudentSerivece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements StudentSerivece {
    @Autowired
    StudentRepository studentRepository;

    @Autowired(required = true)
    StudentNativeRepository studentNativeRepository;
    @Autowired
    ObjectMapper mapper;
    public StudentEntity createStudent(Student student){
        StudentEntity studentEntity = mapper.convertValue(student, StudentEntity.class);
        return studentRepository.save(studentEntity);
    }

    @Override
    public List<Student> retriveStudent() {
        List<Student> list = new ArrayList<>();
        Iterable<StudentEntity> studentRepositoryAll = studentRepository.findAll();
        Iterator<StudentEntity> iterator = studentRepositoryAll.iterator();
        while(iterator.hasNext()){
            StudentEntity entity = iterator.next();
            Student student = mapper.convertValue(entity,Student.class);
            list.add(student);
        }
        return list;
    }


     public boolean removeStudent(Long studentId){
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentId);
        if(studentEntityOptional.isPresent()){
            StudentEntity entity = studentEntityOptional.get();
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
//         return studentNativeRepository.removedStudent(studentId);
    }
}
