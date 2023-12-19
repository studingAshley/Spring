package com.java.www.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;



@Configuration
public class AppConfig {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception
	{
		//myBatis session 연결 
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		
		//쿼리문이 담긴 mapper파일을 모두 가져옴
		Resource[] res = new PathMatchingResourcePatternResolver().getResources(
				"classpath:/mapper/**/*.xml"
				);
		sessionFactoryBean.setMapperLocations(res);
		
		return sessionFactoryBean.getObject();//myBatis DB + mapper 정보가 들어있는 모든 객체
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
	{
		
		return new SqlSessionTemplate(sqlSessionFactory); //myBatis에 사용할 1개 객체를 가져옴.
	}
	
}
