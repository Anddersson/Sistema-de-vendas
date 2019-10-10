/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.List;

import br.com.binary.work.models.ItensPedidoModel;

public interface IItensPedidoDao {
    ItensPedidoModel obterPorId(int id);
    List<ItensPedidoModel> obterPorIdPedido(int id);
    List<ItensPedidoModel> obterTodas();
    void inserir(ItensPedidoModel itensPedido);
    
}
