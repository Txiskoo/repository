package com.curso.spring.repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository
@Qualifier("pedidoRepo")
public class PedidoReposistoryImp implements PedidoRepository {
	
	private static Logger log = LoggerFactory.getLogger(PedidoReposistoryImp.class);
	
	private static Map<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
	private static int id;
	
	static {
		pedidos.put(1,  new Pedido(1, "Luis", "Televisión", new Date(), true));
		pedidos.put(2,  new Pedido(2, "Luis", "Tractor", new Date(), true));
		pedidos.put(3,  new Pedido(3, "Ana", "Buque", new Date(), false));
		id = 3;
	}
	
	

	@Override
	public void add(Pedido pedido) {		
		id++;
		pedido.setId(id);
		pedidos.put(id, pedido);		
		log.info("Has grabado un pedido en la base de datos");
	}


	@Override
	public Collection<Pedido> getPedidoByUser(String user) {
		log.info("user es " + user);
		Collection<Pedido> lista = new ArrayList<>();
		for (Pedido p:  pedidos.values()) {
			if(p.getUser().equals(user)) {
				lista.add(p);
			}
		}

		log.info(lista.toString());
		return lista;
	}
	
	

}
