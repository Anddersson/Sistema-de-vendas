/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.binary.work.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexaoDB {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //para uso do banco de dados na nuvem
    private static final String URL = "jdbc:mysql://co4pmgp5qu3ir81j:ww2ayqeal7qmeicu@sp6xl8zoyvbumaa2.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/f36u5uhese9hsyqm";
    
    //para uso do banco de dados local
    //private static final String URL = "jdbc:mysql://localhost:3306/teste";
    private static final String USER = "root";
    private static final String PASS = "";

    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao se conectar com o banco de dados: ", ex);
        }
    }

    public void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar a conexão: ", ex);
        }
    }

    public void closeConnection(Connection conn, PreparedStatement stmt) {

        closeConnection(conn);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar a conexão: ", ex);
        }
    }

    public void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {

        closeConnection(conn, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Ocorreu um erro ao fechar a conexão: ", ex);
        }
    }
}
