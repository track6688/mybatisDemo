package org.example.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Emp;
import org.example.dto.EmpInfoDto;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
    void save(Emp emp);

    void update(Emp emp);

    void delete(Integer id);

    List<Emp> selectById(Integer id);

    @Select("select * from t_emp t where t.id = #{id} limit 1")
    Emp selectOneById(Integer id);

    @MapKey("id")
    Map<Integer, Emp> selectAllEmpMap();

    EmpInfoDto findEmpInfoDtoById(Integer id);

    EmpInfoDto findEmpInfoDtoSelect(Integer id);

    @Select("select e.id, e.user_name as userName, e.age, e.dept_id as deptId from t_emp e where e.dept_id = #{deptId}")
    Emp findEmpByDeptId(Integer deptId);

}
