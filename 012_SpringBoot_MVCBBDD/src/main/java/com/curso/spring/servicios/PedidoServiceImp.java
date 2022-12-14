package com.curso.spring.servicios;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorio.PedidoJPARepository;

@Service
//@Scope(value = "singleton")
//@Lazy
public class PedidoServiceImp implements PedidosService {

	private static Logger log = LoggerFactory.getLogger(PedidoServiceImp.class);

	//@Autowired
	//@Qualifier("pedidoRepo")
	//private PedidoRepository repo;	
	
	@Autowired
	private PedidoJPARepository repoJPA;
	
	public PedidoServiceImp() {
		log.info("... instanciando PedidoServiceImp " + repoJPA);
	}
	
	@PostConstruct
	public void init() {
		log.info("... postcosntruct " + repoJPA);
	}

	@Override
	public Pedido generarPedido(Pedido p) {
		
		//p.setFechaPedido(new java.util.Date()); 
				//p.setEntregado(false);
				log.info("gestiono un pedido");			
		        return repoJPA.save(p);

	}
	
	@Override
	public Collection<Pedido> getPedidos(String user) {
		if(user == null ) {
			//return repo.getAll();
			return repoJPA.findAll();
		}else {
			//return repo.getPedidosByUser(user);
			Pedido pFiltro = new Pedido();
			pFiltro.setUser(user);
			
			return repoJPA.findByUser(user);
			
		}
	}
	
	@Override
	public Pedido getPedido(Integer id) {		
		return repoJPA.findById(id).orElse(null);
		
	}

	public void eliminarPedido(Integer id) {
		repoJPA.deleteById(id);
	}
	
	public Pedido actualizarPedido(Pedido p) {
		return repoJPA.updateByPedido(p);
	}

}
