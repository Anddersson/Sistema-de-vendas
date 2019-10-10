/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.List;

import br.com.binary.work.models.ClienteModel;


public interface IClienteDao {
    ClienteModel obterPorId(int id);
    List<ClienteModel> obterTodas();
    void inserir(ClienteModel cliente);
    void alterar(ClienteModel cliente); 
    ClienteModel obterPorEmail(String email);
    ClienteModel obterPorCpf(String cpf); 
    ClienteModel obterPorCnpj(String cnpj);
    ClienteModel obterPorDocumento(String documento);
    
}
