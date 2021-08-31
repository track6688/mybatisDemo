package org.example.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Emp;
import org.example.dto.EmpInfoDto;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

    EmpInfoDto findEmpInfoDtoById(Integer id);

    EmpInfoDto findEmpInfoDtoSelect(Integer id);

    @Select("select e.id, e.user_name as userName, e.age, e.dept_id as deptId from t_emp e where e.dept_id = #{deptId}")
    Emp findEmpByDeptId(Integer deptId);

}
