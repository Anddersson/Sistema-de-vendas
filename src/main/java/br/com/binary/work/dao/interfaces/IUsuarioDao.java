/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.List;

import br.com.binary.work.models.UsuarioModel;


public interface IUsuarioDao {
    UsuarioModel obterPorId(int id);
    List<UsuarioModel> obterTodas();
    void inserir(UsuarioModel usuario);
    void alterar(UsuarioModel usuario);
    void inativar(UsuarioModel usuario);
    UsuarioModel autenticar (String nomeUsuario, String senha);
    boolean validarLogin (String login, String senha);
    void alterarSenha(UsuarioModel usuario);
    List<UsuarioModel> obterTodosPorCargo(String cargo);
    List<UsuarioModel> obterTodosPorCargo(String cargo, int idFilial);
}
