package com.techchallenge.core.domain.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techchallenge.adapter.gateways.CategoriaGateway;
import com.techchallenge.core.domain.entities.Categoria;
import com.techchallenge.core.domain.exception.NegocioException;

@Service
public class CategoriaUseCase {

	@Autowired
    private CategoriaGateway gateway;
    
    public List<Categoria> buscarTodos() {
        return gateway.buscarTodos();
    }
    
    public Categoria buscarPorId(Long id) throws NegocioException {
    	return gateway.buscarPorId(id);
    }
}
