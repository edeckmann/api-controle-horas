package eng.elemar.ponto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@SpringBootApplication
public class PontoApplication {

	private static final String HTTP_SWAGGER_IO_TERMS = "http://swagger.io/terms";

	public static void main(String[] args) {
		SpringApplication.run(PontoApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
			.title(HTTP_SWAGGER_IO_TERMS)
			.version("1.0.0")
			.termsOfService("http://swagger.io/terms")
			.license(new License().name("Apache 2.0").url("http://springdoc.org"))
			);

	}

}
