package br.com.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@AutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApiPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPedidoApplication.class, args);
	}

}
