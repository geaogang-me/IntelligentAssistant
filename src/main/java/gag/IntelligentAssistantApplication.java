package gag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("gag.intelligentAssistant.mapper")
public class IntelligentAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntelligentAssistantApplication.class, args);
    }

}
