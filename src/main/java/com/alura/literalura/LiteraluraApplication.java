package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.service.ConsumoApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.executaMenu();
		System.out.println("fim");
//		var consumo = new ConsumoApi();
//		var json = consumo.obterDados("https://gutendex.com/books/?search=dom+casmurro");
//		System.out.println(json);
	}
}
