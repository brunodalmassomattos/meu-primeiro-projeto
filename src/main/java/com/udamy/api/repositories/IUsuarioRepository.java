package com.udamy.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.udamy.api.entities.Usuario;

@Transactional(readOnly = true)
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
}
