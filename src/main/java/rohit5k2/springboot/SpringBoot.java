package rohit5k2.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBoot {
    public static void main(String[] args ){
        SpringApplication application = new SpringApplication(SpringBoot.class);
        application.run(args);
    }
}
