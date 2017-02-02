package com.gslab.dth;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
@ComponentScan(basePackages="com.gslab.dth.data")
public class Config extends AbstractCloudConfig {
	
	
	@Bean
	public DataSource dataSource(){
		return connectionFactory().dataSource();
	}
}
