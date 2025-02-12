package de.dhge.watchops;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
    Path db_file = Path.of("backend/database/db.sqlite");
    Path schema_file = Path.of("backend/database/schema.sqlite");
        File f = new File(db_file.toAbsolutePath().toString());
        if(!f.exists()) { 
            try {
                Files.copy(schema_file.toAbsolutePath(), db_file.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.sqlite.JDBC");
    dataSource.setUrl("jdbc:sqlite:" + db_file.toAbsolutePath().toString());
    dataSource.setUsername("sa");
    dataSource.setPassword("sa");
    return dataSource;
}

}
