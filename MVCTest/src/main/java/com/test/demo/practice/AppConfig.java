package com.test.demo.practice;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@PropertySource({"classpath:application.properties"})
@ComponentScan(basePackages ={"com.test.demo.practice.controller","com.test.demo.service","com.test.demo.repository"})
@EnableJpaRepositories(basePackages = "com.test.demo.repository")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer{

	
    @Autowired
    private Environment env;
    
    
    @Bean
    public DataSource dataSource() throws Exception {
    	DriverManagerDataSource dm = new DriverManagerDataSource();
        dm.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dm.setUrl(env.getProperty("spring.datasource.url"));
        dm.setUsername(env.getProperty("spring.datasource.username"));
        dm.setPassword(env.getProperty("spring.datasource.password"));
        System.out.println("DATASOURCE:::::"+dm);
        System.out.println("DATASOURCE:::::"+dm.getUrl());
        System.out.println("DATASOURCE:::::"+dm.getUsername());
      return dm;
    }    
      
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean em 
          = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan("com.test.demo.repository.entity");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        //em.setJpaProperties(additionalProperties());
        em.setDataSource(dataSource());
        return em;
    }
    
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
        properties.setProperty("spring.jpa.show-sql", env.getProperty("spring.jpa.show-sql"));
        properties.setProperty("hibernate.current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        //properties.setProperty("hibernate.generate_statistics", "true"); 

        return properties;
    }
 
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
