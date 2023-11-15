package pl.pwr.ite.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "pl.pwr.ite")
@EntityScan(basePackages = "pl.pwr.ite")
@EnableJpaRepositories(basePackages = "pl.pwr.ite")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}