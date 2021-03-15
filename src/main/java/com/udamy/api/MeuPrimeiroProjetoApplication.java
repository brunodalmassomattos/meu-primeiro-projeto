package com.udamy.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udamy.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	private static final String SENHA = "123456";
	
	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu primeiro projeto.");
	}
	
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String senhaEncoded = SenhaUtils.gerarBCrypt(SENHA);
			System.out.println("Primeira encriptada:" + senhaEncoded);
			
			System.out.println("Senha confere: " + SenhaUtils.senhaValida(SENHA, senhaEncoded));
			
			System.out.println("Segunda encriptada:" + SenhaUtils.gerarBCrypt(SENHA));
			System.out.println("Senha confere: " + SenhaUtils.senhaValida(SENHA, senhaEncoded));
		};
	}

}
