package com.fuad;

import com.fuad.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class UMSBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(UMSBackendApplication.class, args);
    }

}
