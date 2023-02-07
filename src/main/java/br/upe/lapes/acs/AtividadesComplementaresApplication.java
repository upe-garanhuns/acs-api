package br.upe.lapes.acs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class AtividadesComplementaresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadesComplementaresApplication.class, args);
	}

}
