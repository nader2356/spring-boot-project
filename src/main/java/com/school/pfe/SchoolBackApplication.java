package com.school.pfe;

import com.school.pfe.Config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication
@EnableJpaAuditing
public class SchoolBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolBackApplication.class, args);
	}

}
