package com.senac.SenacSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
public class SenacSpringApplication {

	public Integer quiz(){
		Scanner entrada = new Scanner(System.in);
		Integer pontos = 0;
		System.out.println("A- Quem descobriu o Brasil?" +
				"\n1) João da Cunha" +
				"\n2) Pedro Carlos Amaral" +
				"\n3) Pelé" +
				"\n4) Jamal");
		Integer escolha1 = entrada.nextInt();
		if (escolha1 == 1){
			pontos++;
			System.out.println("Acertou");
		}
		return pontos;
	}

	public String fome(){
		Scanner entrada = new Scanner(System.in);
		String mensagem = null;
		System.out.println("Fome?");
		String fome = entrada.next();
		System.out.println("Dinehiro?");
		String dinheiro = entrada.next();

		if (fome.equals("S") && dinheiro.equals("S")){
			mensagem = "Então vá comer!";
		} else if (fome.equals("N") && dinheiro.equals("S")) {
			mensagem = "Invista seu dinheiro";
		} else {
			mensagem = "Nada";
		}
		return mensagem;
	}


	public static void main(String[] args) {
		SpringApplication.run(SenacSpringApplication.class, args);

	}


//	@GetMapping("/")
//	public String inicio() {
//		return "index";
//	}

	@GetMapping("/ola")
	public String digaOla(@RequestParam(value = "meuNome",
			defaultValue = "Sem Nome") String name) {
		return String.format("Olá %s!", name);
	}

	@GetMapping("/resultado")
	public String resultadoPontos(){
		Integer resultado = quiz();
		return "Parabéns você fez " + resultado.toString() + " pontos!";
	}

	@GetMapping("/fome")
	public String resultadoFome(){
		return fome();
	}
}