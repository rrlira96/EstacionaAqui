package br.unicap.engsoftware.EstacionaAqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
<<<<<<< HEAD
=======

>>>>>>> 2d54e52aec65e4f0df64af4df71bd9e4d55b0288
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
<<<<<<< HEAD
public class EstacionaAquiApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstacionaAquiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer webConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
            }
        };
    }
=======

public class EstacionaAquiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionaAquiApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer webConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
>>>>>>> 2d54e52aec65e4f0df64af4df71bd9e4d55b0288


}
