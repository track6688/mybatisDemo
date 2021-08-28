package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.dao.EmpMapper;
import org.example.domain.Emp;
import org.example.dto.EmpInfoDto;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class EmpTest {

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
     * xml形式
     */
    @Test
    public void test1(){
        Emp emp = new Emp();
        emp.setId(3);
        emp.setUserName("王五");
        emp.setAge(19);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("org.example.dao.EmpMapper.save", emp);
        sqlSession.commit();
    }

    /**
     * 接口绑定
     */
    @Test
    public  void test2(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.selectById(1);
        System.out.printf(emps.toString());
    }

    /**
     * 注解
     */
    @Test
    public void test3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.selectOneById(1);
        System.out.printf("结果：%s", emp);
    }

    /**
     * 查询Map
     */
    @Test
    public void test4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Map<Integer, Emp> integerEmpMap = mapper.selectAllEmpMap();
        System.out.printf("结果：%s", integerEmpMap);
    }


    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        EmpInfoDto empInfoDtoById = empMapper.findEmpInfoDtoById(1);
        System.out.printf("结果：%s", empInfoDtoById);
    }

    @Test
    public void test(){
        EmpMapper mapper = sqlSessionFactory.openSession().getMapper(EmpMapper.class);
        EmpInfoDto empInfoDtoSelect = mapper.findEmpInfoDtoSelect(1);
        System.out.printf("结果：%s", empInfoDtoSelect);
    }

}
