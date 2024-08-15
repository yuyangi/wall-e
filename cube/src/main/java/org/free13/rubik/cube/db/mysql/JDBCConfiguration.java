package org.free13.rubik.cube.db.mysql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class JDBCConfiguration {

    @Bean
    public DataSource dataSource() {
        //DruidDataSourceFactory
        return null;
    }

}
