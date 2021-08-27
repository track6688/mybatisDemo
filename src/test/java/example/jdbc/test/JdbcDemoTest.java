package example.jdbc.test;

import example.jdbc.domain.User;
import org.junit.Test;

import java.sql.*;

/**
 * @author guojz
 */
public class JdbcDemoTest {

    @Test
    public void test() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.创建连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123456");

            // 3.创建SQL语句
            String sql = "select id,user_name,age, create_time from t_user where id=?";
            // 获得sql执⾏者
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);

            // 4、执⾏查询
            //ResultSet rs= pstmt.executeQuery();
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();

            // 5、处理结果
            rs.next();
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            user.setAge(rs.getInt("age"));
            user.setCreateTime(rs.getTimestamp("create_time"));
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

