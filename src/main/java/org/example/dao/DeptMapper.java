package org.example.dao;

import org.example.domain.Dept;
import org.example.dto.DeptInfoDto;

public interface DeptMapper {

    DeptInfoDto findDeptEmpDto(Integer id);

    Dept findDeptById(Integer id);

    DeptInfoDto findDepEmpDtoSelect(Integer id);
}
