package edu.icet.crm.repository.impl;

import edu.icet.crm.repository.StudentNativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
@Repository
public class StudentNativeRepositoryImpl implements StudentNativeRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public boolean removedStudent(long studentId){
        return namedParameterJdbcTemplate.update(
                "DELETE FROM STUDENT WHERE ID==:id",
                Collections.singletonMap("id",studentId))>0;
    }
}
