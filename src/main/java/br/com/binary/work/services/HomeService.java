/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.services;

import br.com.binary.work.dao.HomeDAO;
import br.com.binary.work.models.HomeProdutoModel;
import br.com.binary.work.models.HomeVendaModel;
import br.com.binary.work.models.HomeVendedorModel;


public class HomeService {

    private final HomeDAO homeDao;

    public HomeService() {
        this.homeDao = new HomeDAO();
    }

    public HomeVendedorModel obterHomeVendedor() {
        return this.homeDao.obterHomeVendedor();
    }

    public HomeVendedorModel obterHomeVendedorPorIdFilial(int idFilial) {
        return this.homeDao.obterHomeVendedorPorIdFilial(idFilial);
    }

    public HomeProdutoModel obterHomeProduto() {
        return this.homeDao.obterHomeProduto();
    }

    public HomeProdutoModel obterHomeProdutoPorIdFilial(int idFilial) {
        return this.homeDao.obterHomeProduto(idFilial);
    }

    public HomeVendaModel obterHomeVendas() {
        return this.homeDao.obterHomeVendas();
    }

    public HomeVendaModel obterHomeVendasPorIdFilial(int idFilial) {
        return this.homeDao.obterHomeVendas(idFilial);
    }
}
