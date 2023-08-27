package com.techchallenge.adapter.gateways;

import java.util.List;

import com.techchallenge.core.domain.entities.Pedido;
import com.techchallenge.core.domain.entities.StatusPedido;


public interface PedidoGateway {

    List<Pedido> buscarPedidos();
    Pedido buscarPedidoPorId(Long id);
    List<Pedido> buscarPedidosPorStatus(StatusPedido statusPedido);
    Pedido buscarPedidoPorIdEStatus(Long id, StatusPedido statusPedido);
    void atualizarStatusDoPedido(Pedido pedido, StatusPedido statusPedido);
    void atualizar(Pedido pedido);
    void excluir(Long pedidoId);
}