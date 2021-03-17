package com.udamy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.udamy.api.entities.Empresa;
import com.udamy.api.repositories.IEmpresaRepository;
import com.udamy.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	private static final String SENHA = "123456";

	@Autowired
	private IEmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu primeiro projeto Srping");
	}

	public CommandLineRunner commandLineRunner1() {
		return args -> {
			String senhaEncoded = SenhaUtils.gerarBCrypt(SENHA);
			System.out.println("Primeira encriptada:" + senhaEncoded);

			System.out.println("Senha confere: " + SenhaUtils.senhaValida(SENHA, senhaEncoded));

			System.out.println("Segunda encriptada:" + SenhaUtils.gerarBCrypt(SENHA));
			System.out.println("Senha confere: " + SenhaUtils.senhaValida(SENHA, senhaEncoded));
		};
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Razao Social");
			empresa.setCNPJ("123.123.123-0001/01");

			this.empresaRepository.save(empresa);

			List<Empresa> empresas = this.empresaRepository.findAll();
			empresas.forEach(System.out::println); // <- não faço ideia do que é isto
		};
	}

}
