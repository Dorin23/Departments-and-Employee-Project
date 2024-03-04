package utcn.departamentManager.DepartamentManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Or specify a path pattern for only your API endpoints
                        .allowedOrigins("http://127.0.0.1:8080", "http://localhost:8080") // The origin(s) to allow
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // The HTTP methods to allow
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}


