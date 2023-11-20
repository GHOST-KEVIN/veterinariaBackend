package veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableJpaRepositories
@MapperScan("veterinaria.mappers")
//@ComponentScan(basePackages = "veterinaria.mappers")
public class VeterinariaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaBackendApplication.class, args);
	}

}
