package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.DeptMapper;
import org.example.dao.EmpMapper;
import org.example.dao.UserMapper;
import org.example.domain.User;
import org.example.dto.DeptInfoDto;
import org.example.dto.EmpInfoDto;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleTest {
    SqlSessionFactory sqlSessionFactory;


    @Before
    public void init(){

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testSelectMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        Map<String, User> userNameMap = sqlSession.selectMap("org.example.dao.UserMapper.selectByList", ids,"userName");
        System.out.println("结果：" + userNameMap);
    }

    @Test
    public void testPlugin(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testDynamic(){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String, Object> params = new HashMap<>();
        params.put("year", 2021);
        params.put("id", 1);

        User user2021 = sqlSession.selectOne("org.example.dao.UserMapper.selectByYearTable2", params);
        System.out.println("2021表数据：" + user2021);
    }

    // 测试多对一 结果嵌套
    // 查询员工信息，及其部门信息
    @Test
    public void testManyToOneResult(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpInfoDto empInfoDto = mapper.findEmpInfoDtoById(1);
        System.out.println("结果：" + empInfoDto);
    }

    // 测试多对一 嵌套查询
    //查询员工信息，及其部门信息
    @Test
    public void testManyToOneSelect(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpInfoDto empInfoDto = mapper.findEmpInfoDtoSelect(1);
        System.out.println("结果：" + empInfoDto);
    }

    // 测试多对一 结果嵌套
    // 查询部门信息，及其所有员工
    @Test
    public void testOneToManyResult(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        DeptInfoDto deptEmpDto = mapper.findDeptEmpDto(1);

        System.out.printf("结果：%s", deptEmpDto);
    }

    // 测试多对一 嵌套查询
    // 查询部门信息，及其所有员工
    @Test
    public void testOneToManySelect(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        DeptInfoDto deptEmpDto = mapper.findDepEmpDtoSelect(1);

        System.out.printf("结果：%s", deptEmpDto);
    }

    @Test
    public void testSameSta(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Long id = 1L;
        Object obj = sqlSession.selectOne("findAll", id);
        System.out.println(obj);
    }



}
