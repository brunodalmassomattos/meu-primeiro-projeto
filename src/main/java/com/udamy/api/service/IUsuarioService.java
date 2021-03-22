package com.udamy.api.service;

import java.util.Optional;

import com.udamy.api.entities.Usuario;

public interface IUsuarioService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorEmail(String email);

}
