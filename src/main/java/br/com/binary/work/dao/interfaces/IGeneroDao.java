/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.List;

import br.com.binary.work.models.GeneroModel;


public interface IGeneroDao {
    GeneroModel obterPorId(int id);
    List<GeneroModel> obterTodas();
    void inserir(GeneroModel genero);
    void alterar(GeneroModel genero);
    void excluir(GeneroModel genero); 
    
}
