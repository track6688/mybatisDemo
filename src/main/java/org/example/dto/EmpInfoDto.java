package org.example.dto;

import lombok.Data;
import org.example.domain.Dept;

@Data
public class EmpInfoDto {
    private String userName;
    private Integer age;
    private Dept dept;
}
