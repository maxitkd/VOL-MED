package med.voll.api.infra.doc;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
public class SpringDocConfiguration {

   @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()      //aca va la llave
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));


    @Bean
    public void message(){
        System.out.println("Beater it's working");
    }
}*/
