package za.ac.cput.departmentmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"Domain", "Factory", "Util", "Repository", "Service", "Controller"})
@EntityScan(basePackages = {"Domain"})
@EnableJpaRepositories(basePackages = {"Repository"})
public class DepartmentManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentManagementSystemApplication.class, args);
    }
}
