package com.example.javaspringbootdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
//@MapperScan("com.example.javaspringbootdemo.mapper")
//public class MyBatisConfig {
//
////    @Bean
////    public DataSource dataSource() {
////        return new HikariDataSource(); // 根据你的数据源选择适当的 DataSource
////    }
////
////    @Bean
////    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
////        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
////        factoryBean.setDataSource(dataSource);
////        return factoryBean.getObject();
////    }
////
////    @Bean
////    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
////        return new SqlSessionTemplate(sqlSessionFactory);
////    }
//}

@Configuration
public class MybatisConfiguration {
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
      	//添加分页拦截器到MybatisPlusInterceptor中
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}