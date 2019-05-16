package com.educare;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.educare.multidb.MyRoutingDataSource;

@SpringBootApplication
@ComponentScan("com.*")
@EnableAutoConfiguration(exclude = { //
		DataSourceAutoConfiguration.class, //
		DataSourceTransactionManagerAutoConfiguration.class })
// Load to Environment
// (@see resources/datasource-cfg.properties).
@PropertySources({ @PropertySource("classpath:datasource-cfg.properties") })
public class ElectusEduCareApplication extends SpringBootServletInitializer {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(ElectusEduCareApplication.class, args);
	}

	@Value("${spring.datasource.driver-class-name.1}")
	String driverclassname;

	@Value("${spring.datasource.username.1}")
	String dbusername;

	@Value("${spring.datasource.password.1}")
	String dbpassword;

	// Returns Routing DataSource (MyRoutingDataSource)
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource(DataSource dataSourcedefault, DataSource electusQA, DataSource shivajividhya,
			DataSource vagdhevi, DataSource surya, DataSource akshara, DataSource vishra,DataSource shakuntala,DataSource metagate,DataSource chiselon,DataSource Pioneer) {

		MyRoutingDataSource dataSource = new MyRoutingDataSource();

		dataSource.initDataSources(dataSourcedefault, electusQA, shivajividhya, vagdhevi, surya, akshara,vishra,shakuntala,metagate,chiselon,Pioneer);

		return dataSource;
	}

	/* default */
	@Bean(name = "dataSourcedefault")
	public DataSource getDefaultsDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.1"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}

	/* ss_electus_podili */
	@Bean(name = "electusQA")
	public DataSource getPodiliDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.2"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);

		return dataSource;
	}

	/* ss_electus_chali */
	@Bean(name = "shivajividhya")
	public DataSource getChalivendramDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.3"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);

		return dataSource;
	}

	/* ss_electus_Darsi */
	@Bean(name = "vagdhevi")
	public DataSource getDarsiDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.4"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);

		return dataSource;
	}

	@Bean(name = "surya")
	public DataSource getSuryaDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.5"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);

		return dataSource;
	}

	@Bean(name = "akshara")
	public DataSource getAksharaDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.6"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);

		return dataSource;
	}
	
	@Bean(name = "vishra")
	public DataSource getVishraDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.7"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}
	@Bean(name = "shakuntala")
	public DataSource getShakuntalaDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.8"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}
	@Bean(name = "metagate")
	public DataSource getMetagateDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.9"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}
	
	@Bean(name = "chiselon")
	public DataSource getChiselonDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.10"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}
	@Bean(name = "Pioneer")
	public DataSource getPioneerDataSource() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// See: datasource-cfg.properties
		dataSource.setDriverClassName(driverclassname);
		dataSource.setUrl(env.getProperty("spring.datasource.url.11"));
		dataSource.setUsername(dbusername);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();

		txManager.setDataSource(dataSource);

		return txManager;
	}

	@Bean
	public ErrorPageFilter errorPageFilter() {
		return new ErrorPageFilter();
	}
	

	
}
