package org.example.dto;

import lombok.Data;
import org.example.domain.Emp;

import java.util.List;

@Data
public class DeptInfoDto {
    private String deptName;
    private List<Emp> emps;
}
