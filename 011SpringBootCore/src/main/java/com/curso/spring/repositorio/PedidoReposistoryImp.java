package com.curso.spring.repositorio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository

@Qualifier("pedidoRepo")
public class PedidoReposistoryImp implements PedidoRepository {
	
	private static Logger log = LoggerFactory.getLogger(PedidoReposistoryImp.class);
	
	

	@Override
	public void add(Pedido pedido) {
		log.info("Has grabado un pedido en la base de datos");

	}

}
