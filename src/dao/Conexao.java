/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lubuntu
 */
public class Conexao {
    
    
    /*public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        conexao.desconectar(conn);
    }*/
    
    public Connection conectar(){
        
        Connection conn = null;
        
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");    // O DRIVER USADO AQUI É DIFERENTE DO USADO EM AULA, POIS TIVE PROBLEMAS DE VERSÃO
          
          String url = "jdbc:mysql://localhost:3306/projeto_poo";
          String USER = "root";
          String PASSWORD = "plac123123";   // MUDAR A SENHA DO BANCO PARA USAR EM OUTRA MÁQUINA

          conn = (Connection) DriverManager.getConnection(url, USER, PASSWORD);
          //conn = DriverManager.getConnection(url, USER, PASSWORD);
          System.out.println("--------------------------------------");
          System.out.println("Conectou no banco de dados.");
        } catch (SQLException ex) {
            System.out.println("--------------------------------------");
            System.out.println("Erro: "+ex+ "--- Não conseguiu conectar no BD.");
        } catch (ClassNotFoundException ex) {
            System.out.println("--------------------------------------");
            System.out.println("Erro: Não encontrou o driver do BD.");
        }
        return conn;
    }
    
    public void desconectar(Connection conn) {
        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Não conseguiu desconectar do BD.");
        }
    }
}
