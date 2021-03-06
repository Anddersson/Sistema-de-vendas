/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.binary.work.dao.interfaces.IItensPedidoDao;
import br.com.binary.work.data.ConexaoDB;
import br.com.binary.work.models.ItensPedidoModel;


public class ItensPedidoDAO implements IItensPedidoDao {

    private final ConexaoDB conexao = new ConexaoDB();
    private PreparedStatement stmt = null;
    private final ProdutoDAO produtoDao = new ProdutoDAO();
    private ResultSet rs = null;

    @Override
    public ItensPedidoModel obterPorId(int id) {
        Connection conn = conexao.getConnection();
        ItensPedidoModel itensPedido = null;

        try {
            stmt = conn.prepareStatement("SELECT "
                    + "IDITENSPEDIDO, "
                    + "IDPRODUTO, "
                    + "VALORUNITARIO, "
                    + "QUANTIDADE, "
                    + "IDPEDIDO"
                    + " FROM itenspedido WHERE IDITENSPEDIDO = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                itensPedido = new ItensPedidoModel(
                        rs.getInt("IdCategoria"),
                        rs.getInt("IdProduto"),
                        rs.getDouble("ValorUnitario"),
                        rs.getInt("Quantidade"),
                        rs.getInt("IdPedido"));
            }
            itensPedido.setProduto(produtoDao.obterPorId(itensPedido.getIdProduto()));

            return itensPedido;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<ItensPedidoModel> obterTodas() {
        Connection conn = conexao.getConnection();
        ItensPedidoModel itensPedido = null;
        List<ItensPedidoModel> itensPedidos = new ArrayList<ItensPedidoModel>();

        try {
            stmt = conn.prepareStatement("SELECT "
                    + "IDITENSPEDIDO, "
                    + "IDPRODUTO, "
                    + "VALORUNITARIO, "
                    + "QUANTIDADE, "
                    + "IDPEDIDO"
                    + " FROM itenspedido");

            rs = stmt.executeQuery();
            while (rs.next()) {
                itensPedido = new ItensPedidoModel(
                        rs.getInt("IdItensPedido"),
                        rs.getInt("IdProduto"),
                        rs.getDouble("ValorUnitario"),
                        rs.getInt("Quantidade"),
                        rs.getInt("IdPedido")
                );
                itensPedido.setProduto(produtoDao.obterPorId(itensPedido.getIdProduto()));

                itensPedidos.add(itensPedido);
            }

            return itensPedidos;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public List<ItensPedidoModel> obterPorIdPedido(int id) {
        Connection conn = conexao.getConnection();
        ItensPedidoModel itensPedido = null;
        List<ItensPedidoModel> itensPedidos = new ArrayList<ItensPedidoModel>();

        try {
            stmt = conn.prepareStatement("SELECT "
                    + "IDITENSPEDIDO, "
                    + "IDPRODUTO, "
                    + "VALORUNITARIO, "
                    + "QUANTIDADE, "
                    + "IDPEDIDO "
                    + " FROM itenspedido"
                    + " WHERE IDPEDIDO = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                itensPedido = new ItensPedidoModel(
                        rs.getInt("IdItensPedido"),
                        rs.getInt("IdProduto"),
                        rs.getDouble("ValorUnitario"),
                        rs.getInt("Quantidade"),
                        rs.getInt("IdPedido")
                );
                itensPedido.setProduto(produtoDao.obterPorId(itensPedido.getIdProduto()));

                itensPedidos.add(itensPedido);
            }

            return itensPedidos;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            conexao.closeConnection(conn, stmt, rs);
        }
    }

    @Override
    public void inserir(ItensPedidoModel itensPedido) {
        Connection conn = conexao.getConnection();

        try {
            stmt = conn.prepareStatement("INSERT INTO itenspedido("
                    + "IDPRODUTO, "
                    + "VALORUNITARIO, "
                    + "QUANTIDADE, "
                    + "IDPEDIDO) "
                    + " VALUES (?, ?, ?, ?)");

            stmt.setInt(1, itensPedido.getIdProduto());
            stmt.setDouble(2, itensPedido.getValorUnitario());
            stmt.setInt(3, itensPedido.getQuantidade());
            stmt.setInt(4, itensPedido.getIdPedido());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt);
            throw new RuntimeException(ex.getMessage());
        } finally {
            conexao.closeConnection(conn, stmt);
        }
    }
    
    public List<ItensPedidoModel> obterPorIdProduto(int id) {
        Connection conn = conexao.getConnection();
        ItensPedidoModel itensPedido = null;
        List<ItensPedidoModel> itensPedidos = new ArrayList<ItensPedidoModel>();

        try {
            stmt = conn.prepareStatement("SELECT "
                    + "IDITENSPEDIDO, "
                    + "IDPRODUTO, "
                    + "VALORUNITARIO, "
                    + "QUANTIDADE, "
                    + "IDPEDIDO "
                    + " FROM itenspedido"
                    + " WHERE IDPRODUTO = ?");

            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                itensPedido = new ItensPedidoModel(
                        rs.getInt("IdItensPedido"),
                        rs.getInt("IdProduto"),
                        rs.getDouble("ValorUnitario"),
                        rs.getInt("Quantidade"),
                        rs.getInt("IdPedido")
                );
                itensPedido.setProduto(produtoDao.obterPorId(itensPedido.getIdProduto()));

                itensPedidos.add(itensPedido);
            }

            return itensPedidos;
        } catch (SQLException ex) {
            conexao.closeConnection(conn, stmt, rs);
            return null;
        } finally {
            conexao.closeConnection(conn, stmt, rs);
        }
    }

}
