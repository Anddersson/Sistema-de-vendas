/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.List;

import br.com.binary.work.models.FilialModel;


public interface IFilialDao {
    FilialModel obterPorId(int id);
    List<FilialModel> obterTodas();
    List<FilialModel> obterTodasAtivas();
    void inserir(FilialModel filial);
    void alterar(FilialModel filial);
    FilialModel obterPorCnpj(String cnpj);
}
