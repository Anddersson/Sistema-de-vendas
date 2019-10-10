/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.services;

import java.util.List;

import br.com.binary.work.dao.ItensPedidoDAO;
import br.com.binary.work.models.ItensPedidoModel;


public class ItensPedidoService {
    private final ItensPedidoDAO itensPedidoDao;
    
    public ItensPedidoService(){
        this.itensPedidoDao = new ItensPedidoDAO();
    }
    
    public List<ItensPedidoModel> obterTodos(){
        return this.itensPedidoDao.obterTodas();
    }
}
