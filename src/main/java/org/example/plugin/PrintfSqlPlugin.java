package org.example.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;



@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})})
public class PrintfSqlPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //System.out.println("PrintfSqlPlugin#intercept方法");
        //System.out.println(invocation);

        Object arg0 = invocation.getArgs()[0];
        System.out.println("完整SQL:" + arg0);



        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        //System.out.println("PrintfSqlPlugin#plugin方法");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //System.out.println("PrintfSqlPlugin#setProperties方法");
        Interceptor.super.setProperties(properties);
    }
}
