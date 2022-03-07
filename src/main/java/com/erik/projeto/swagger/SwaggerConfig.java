package com.erik.projeto.swagger;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//URI para visualizar a documentacao em formato HTML "http://localhost:8080/xx/swagger-ui.html#".

@Configuration 
@EnableSwagger2
public class SwaggerConfig {

	
	
	@Bean
	public Docket api() {
		
		//Criando um obj "Docket", que eh um objeto que o Spring, internamente vai usar para gerar a pagina html Swagger de documentacao.
		Docket docketASerRetornado = new Docket( DocumentationType.SWAGGER_2 );
		
		                                                                      
		return docketASerRetornado.select()
			 	                  .apis(RequestHandlerSelectors.basePackage("com.erik.projeto.controllers"))
				                  .paths( PathSelectors.any() )
				                  .build()
				                  .apiInfo( apiInfo() )
				                  .useDefaultResponseMessages(false); //Elimina as respostas padroes da documentacao visual do swagger.
	}


	private ApiInfo apiInfo() {
		
		
		//Definição de texto da pagina da documentação visual.
	    String  title             = "Documentação - Projeto 'Avaliação Tecnica Mobi - Startaideia'";
	    String  description       = "Lista de endpoints da aplicação com detalhamento";
        String  version           = "1.0";
        String  termsOfServiceUrl = "https://www.eriklima.com/";
        String  license           = "Licensa - Todos os direitos reservados.";
        String  licenseUrl        = "https://www.eriklima.com";
        Contact contact           = new Contact("Erik Lima", "https://www.eriklima.com", "erik.f.alves.lima@gmail.com");

	
        ApiInfo apiInfo = new ApiInfo( 
        		                       title, 
        		                       description, 
        		                       version, 
        		                       termsOfServiceUrl, 
        		                       contact, 
        		                       license, 
        		                       licenseUrl, 
	                                   Collections.emptyList()
	                                  );
	    return apiInfo;	
	}

}