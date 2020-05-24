package com.test.demo.practice;

import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(basePackages = "com.test.demo.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.test.demo.repository")
public class AppConfig1 extends WebMvcConfigurerAdapter{

	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dm = new DriverManagerDataSource()
		dm.setDriverClassName(arg0);
		dm.setUrl(url);
		dm.setUsername(username);
		dm.setPassword(password);
		return dm;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getLocalEm(){
		   LocalContainerEntityManagerFactoryBean em 
	          = new LocalContainerEntityManagerFactoryBean();
		   em.setPackagesToScan(packagesToScan);
		   JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		   em.setJpaVendorAdapter(jpaVendorAdapter);
		   em.setDataSource(getDataSource());
	}
	
	@Bean
	public JpaTransactionManager getJpstm(){
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		return JpaTransactionManager;
	}
	
	
}
