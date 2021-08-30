import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.UserMapper;
import org.example.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author guojz
 */

public class MybatisSpringTest {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.findUserById(1L);
        System.out.println(user);
    }
}

