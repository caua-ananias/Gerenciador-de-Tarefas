package com.cauaananias.gerenciadordetarefas.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Gerenciador de Tarefas API")
                        .version("1.0")
                        .description("API para gerenciamento de tarefas com operações de CRUD")
                        .contact(new Contact()
                                .name("Desenvolvedor Back-end Cauã Ananias")
                                .email("caua.ananias2004@gmail.com")
                        )
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")
                        )
                );
    }
}
