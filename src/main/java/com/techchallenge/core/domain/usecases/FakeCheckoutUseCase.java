package com.techchallenge.core.domain.usecases;

import java.time.OffsetDateTime;

import com.techchallenge.core.domain.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakeCheckoutUseCase {
	
	@Autowired
	private PedidoUseCase pedidoUseCase;
	@Autowired
	private ProdutoUseCase produtoUseCase;
	@Autowired
	private ClienteUseCase clienteUseCase;
	
	public Pedido checkout(Pedido pedido) {
		
		this.validarItens(pedido);
		this.validarCliente(pedido);
		
		pedido.setDataSolicitacao(OffsetDateTime.now());
		pedido.setStatus(StatusPedido.RECEBIDO);
		pedido.calcularValor();
		pedido.setStatusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO);
		
		return pedidoUseCase.gravar(pedido);
	}
	
	private void validarItens(Pedido pedido) {
	    pedido.getItens().forEach(item -> {
	    	Long produtoId = item.getProduto().getId();
	    	
	    	Produto produto = produtoUseCase.buscarPorId(produtoId);
	    	
	        item.setPedido(pedido);
	        item.setProduto(produto);
	        item.calcularPrecoTotal();
	    });
	}
	
	private void validarCliente(Pedido pedido) {
		Cliente cliente = clienteUseCase.buscarPorId(pedido.getCliente().getId());
		pedido.setCliente(cliente);
	}
}
