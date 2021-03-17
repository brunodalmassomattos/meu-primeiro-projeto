package com.udamy.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udamy.api.entities.Empresa;

public interface IEmpresaRepository extends JpaRepository<Empresa, Long> {
	Empresa findByCnpj(String cnpj);
}
