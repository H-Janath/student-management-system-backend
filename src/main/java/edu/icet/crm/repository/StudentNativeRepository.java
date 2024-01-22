package edu.icet.crm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Collections;

public class StudentNativeRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    boolean removedStudent(long studentId){
        int updateStatus = namedParameterJdbcTemplate.update(
                "DELETE FROM STUDENT WHERE ID==:id",
                Collections.singletonMap("id",studentId)
        );
        return (updateStatus>0)? true:false;
    }
}
