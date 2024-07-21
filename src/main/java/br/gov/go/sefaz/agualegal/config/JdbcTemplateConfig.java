package br.gov.go.sefaz.agualegal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JdbcTemplateConfig {

	//@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		//dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		//dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/oracle");
		//dataSource.setUsername("AGUALEGAL");
		//dataSource.setPassword("Senha_123");
		////dataSource.setUrl("jdbc:oracle:thin:@(description= (retry_count=20)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.sa-saopaulo-1.oraclecloud.com))(connect_data=(service_name=g72e820369101ca_dbagualegal_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))");
		//dataSource.setUsername("DB_AGUA_LEGAL");
	//	dataSource.setPassword("B4nc0_$GU$");
		
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
