package edu.icet.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@AllArgsConstructor

public class Course {

    private String code;
    private String description;
    private String duration;

    public void setCode(String code) {
        if(StringUtils.isEmpty(code))return;
        this.code = code;
    }

}
