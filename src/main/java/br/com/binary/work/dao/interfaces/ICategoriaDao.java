/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.List;

import br.com.binary.work.models.CategoriaModel;


public interface ICategoriaDao {
    CategoriaModel obterPorId(int id);
    List<CategoriaModel> obterTodas();
    void inserir(CategoriaModel categoria);
    void alterar(CategoriaModel categoria);
    void excluir(CategoriaModel categoria);    
}
