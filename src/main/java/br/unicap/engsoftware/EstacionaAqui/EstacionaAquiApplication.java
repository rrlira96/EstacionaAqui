package br.unicap.engsoftware.EstacionaAqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EstacionaAquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionaAquiApplication.class, args);
	}

}
