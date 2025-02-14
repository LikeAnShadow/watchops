package de.dhge.watchops;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class WatchopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchopsApplication.class, args);
	}


@Bean
public DataSource dataSource() {
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
    dataSource.setUrl("jdbc:mariadb://" + System.getenv("DB_HOST") + "/" + System.getenv("DB_NAME")+ "?createDatabaseIfNotExist=true");
    dataSource.setUsername(System.getenv("DB_USER"));
    dataSource.setPassword(System.getenv("DB_PASSWORD"));
    return dataSource;
}

}