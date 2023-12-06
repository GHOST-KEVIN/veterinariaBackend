package veterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class VeterinariaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinariaBackendApplication.class, args);
    }
}