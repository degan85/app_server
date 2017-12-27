package com.ibk.app_server.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.util.concurrent.Service;
import com.jolbox.bonecp.BoneCPDataSource;

@EnableTransactionManagement
@MapperScan(basePackages="com.ibk.app_server.mapper.mysql", sqlSessionFactoryRef="sqlSessionFactoryMySql")
@Configuration
@ComponentScan(basePackages = {"com.ibk.app_server.service"})
public class ASdbConfig {

	@Value("${local.db.driver.class}")
	private String driver;
	
	@Value("${local.db.jdbc.url}")
	private String url;
	
	@Value("${local.db.uername}")
	private String username;
	
	@Value("${local.db.password}")
	private String password;

	@Primary
	@Bean(name="asdbMySql", destroyMethod="close")
	public DataSource dataSourceMySql() {
		BoneCPDataSource ds = new BoneCPDataSource();
		
		ds.setDriverClass(driver);
		ds.setJdbcUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		
		return ds;
	}
	
	@Bean(name="asdbTx")
	public PlatformTransactionManager transactionManagerMobdb() {
		return new DataSourceTransactionManager(dataSourceMySql());
	}

	
	@Bean
	public SqlSessionFactory sqlSessionFactoryMySql() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSourceMySql());
		
		return sessionFactory.getObject();
	}
	
	public String getProperties() {
		System.out.println("username : "+username);
		return username;
	}
	
	
	
	
	
	
	
	
	
}
