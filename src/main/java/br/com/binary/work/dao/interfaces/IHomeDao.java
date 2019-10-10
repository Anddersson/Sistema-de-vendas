/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import br.com.binary.work.models.HomeProdutoModel;
import br.com.binary.work.models.HomeVendaModel;
import br.com.binary.work.models.HomeVendedorModel;


public interface IHomeDao {

    HomeVendedorModel obterHomeVendedorPorIdFilial(int idFilial);

    HomeVendedorModel obterHomeVendedor();

    HomeProdutoModel obterHomeProduto();

    HomeProdutoModel obterHomeProduto(int idFilial);

    HomeVendaModel obterHomeVendas();

    HomeVendaModel obterHomeVendas(int idFilial);
}
