package org.example.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;



@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
public class PrintfSqlPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //System.out.println("PrintfSqlPlugin#intercept方法");
        //System.out.println(invocation);
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object params = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];

        if (args.length > 4) {
            CacheKey cacheKey = (CacheKey) args[4];
            BoundSql boundSql = (BoundSql) args[5];
        }

        String sql = ms.getBoundSql(params).getSql();
        System.out.println(ms.getId());
        System.out.println("完整SQL:" + sql);
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
