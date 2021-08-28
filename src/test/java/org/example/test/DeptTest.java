package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.DeptMapper;
import org.example.dto.DeptInfoDto;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class DeptTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询一个部门下的所有人
     */
    @Test
    public void test1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        DeptInfoDto deptEmpDto = mapper.findDeptEmpDto(1);

        System.out.printf("结果：%s", deptEmpDto);
    }
/**
     * 查询一个部门下的所有人
     */
    @Test
    public void test2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        DeptInfoDto deptEmpDto = mapper.findDepEmpDtoSelect(1);

        System.out.printf("结果：%s", deptEmpDto);
    }

}
