package com.claro.miclaro.validacion.comprapaquete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claro.miclaro.validacion.comprapaquete.entity.PaqueteCompras;

@Repository
public interface PaqueteComprasRepositorio extends JpaRepository<PaqueteCompras, Long> {
	List<PaqueteCompras> findByTipoCliente(String tipoCliente);
}
