package br.senac.tads.dsw.dados_pessoais;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public Mensagem hello() {
		return new Mensagem("Enzo de Oliveira Conceição da Silva", "Olá, mundo! meu primeiro Spring Boot");
	}
}
