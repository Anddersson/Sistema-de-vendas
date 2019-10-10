/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao.interfaces;

import java.util.Date;
import java.util.List;

import br.com.binary.work.models.RelatorioClienteModel;


public interface IRelatorioClienteDao {
    List<RelatorioClienteModel> obterPorData(Date dataInicio, Date dataFim);
}
