//package org.example.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.example.domain.User;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//
///**
// * <pre>
// * mybatis-spring
// * </pre>
// *
// * @author jiazhen.guo@meicloud.com
// * @version 1.00.00
// * @createDate 2021/8/30 11:41
// * <pre>
// * 修改记录
// *    修改后版本:     修改人：  修改日期:     修改内容:
// * </pre>
// */
//@EnableTransactionManagement
//@Configuration
//@MapperScan(basePackages = "org.example.mapper")
//@ComponentScan(basePackages = {"org.example"})
//@Repository
//public class MybatisConfig {
//
//    /**
//     *  <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource"> </bean>
//     *
//     *  <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactory">
//     *  datasource
//     *  mapper文件的路径
//     *  别名
//     *
//     *  </bean>
//     *
//     *  <mapper‐scan basePackage=""/>
//     *  @return
//     *  @throws IOException
//     *     */
//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource());
//        // 设置 MyBatis 配置文件路径
//        factoryBean.setConfigLocation(new ClassPathResource("mybatis‐config.xml"));
//        // 设置 SQL 映射文件路径
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        factoryBean.setTypeAliases(User.class);
//
//        return factoryBean;
//    }
//
//
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        return dataSource;
//        }
//
//
//}
//
