/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Exercicio;

/**
 *
 * @author lubuntu
 */
public class ExercicioDAO {
    
    public ExercicioDAO(){
    
    }
    
    public void inserirProfessor(Exercicio e){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {

            PreparedStatement pst = conn.prepareStatement("INSERT INTO exercicio (nome, parte_corpo, qtd_series, tempo_intervalo)"
                    + " VALUES ( ?, ?, ?, ?)");

            pst.setString(1, e.getNomeEx());
            pst.setString(2, e.getParte_corpo());
            pst.setInt(3, e.getQtd_series());
            pst.setString(4, e.getTempo_intervalo());
            
            pst.execute();
            System.out.println("Insert exercicio OK");
            pst.close();

            JOptionPane.showMessageDialog(null, "Exercício cadastrado!");
            System.out.println("Exercicio cadastrado.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar no BD.");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Exercício");
        } finally {
          conexao.desconectar(conn);
        }
    }
    
    public ArrayList consultarExercicio() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Exercicio ex = null;
        ArrayList<Exercicio> exercicio = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM exercicio;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                ex = new Exercicio();
                ex.setCod_exerc(rs.getInt("COD_EXERCICIO"));
                ex.setNomeEx(rs.getString("NOME"));
                ex.setParte_corpo(rs.getString("PARTE_CORPO"));
                ex.setQtd_series(rs.getInt("QTD_SERIES"));
                ex.setTempo_intervalo(rs.getString("TEMPO_INTERVALO"));
                exercicio.add(ex);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados de Exercício.");
        } finally {
            conexao.desconectar(conn);
        }
        return exercicio;
    }
    
    public ArrayList consultarExercicioCodigo(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Exercicio ex = null;
        ArrayList<Exercicio> exercicio = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM exercicio WHERE " + campo + " = " + valor + ";";
            System.out.println(consulta);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            while(rs.next()){
                ex = new Exercicio();
                ex.setCod_exerc(rs.getInt("COD_EXERCICIO"));
                ex.setNomeEx(rs.getString("NOME"));
                ex.setParte_corpo(rs.getString("PARTE_CORPO"));
                ex.setQtd_series(rs.getInt("QTD_SERIES"));
                ex.setTempo_intervalo(rs.getString("TEMPO_INTERVALO"));
                exercicio.add(ex);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados de Exercício.");
        } finally {
            conexao.desconectar(conn);
        }
        return exercicio;
    }
    
    public ArrayList consultarExercicioPersonalizada(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Exercicio ex = null;
        ArrayList<Exercicio> exercicio = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM exercicio WHERE " + campo + " LIKE " + "'%"+valor+"%'" + ";";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                ex = new Exercicio();
                ex.setCod_exerc(rs.getInt("COD_EXERCICIO"));
                ex.setNomeEx(rs.getString("NOME"));
                ex.setParte_corpo(rs.getString("PARTE_CORPO"));
                ex.setQtd_series(rs.getInt("QTD_SERIES"));
                ex.setTempo_intervalo(rs.getString("TEMPO_INTERVALO"));
                exercicio.add(ex);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados de Exercício.");
        } finally {
            conexao.desconectar(conn);
        }
        return exercicio;
    }
    
    public void excluirExercicio(String cod_exercicio){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
         try {

            String delete = "DELETE FROM exercicio WHERE cod_exercicio = " + cod_exercicio + ";";
            PreparedStatement pst = conn.prepareStatement(delete);
            System.out.println(delete);
            pst.execute();

            JOptionPane.showMessageDialog(null,"Exclusão de Exercicio OK","",1);
          
            pst.close();
            conexao.desconectar(conn);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        }
    }
    
    public void excluirExercicioAlteracao(int cod_exercicio, int cod_treino){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
         try {

            String delete = "DELETE FROM exercicio_treino WHERE cod_exercicio = " + cod_exercicio + " and cod_treino = " + cod_treino + ";";
            PreparedStatement pst = conn.prepareStatement(delete);
            System.out.println(delete);
            pst.execute();
          
            pst.close();
            conexao.desconectar(conn);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        }
    }
    
    public void alterarExercicio(Exercicio exercicio){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        try{    
            PreparedStatement pst = conn.prepareStatement(
                "UPDATE exercicio " +
                "SET " +
                "    nome = ?, " +
                "    parte_corpo = ?, " +
                "    qtd_series = ?, " +
                "    tempo_intervalo = ? " +
                "WHERE " +
                "cod_exercicio = ?;");
 
            pst.setString(1, exercicio.getNome());
            pst.setString(2, exercicio.getParte_corpo());
            pst.setInt(3, exercicio.getQtd_series());
            pst.setString(4, exercicio.getTempo_intervalo());
            pst.setInt(5, exercicio.getCod_exerc());
            
            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+
            e.getMessage(), "Alteração de Exercícios", 0);
        }finally{
            conexao.desconectar(conn);
        }
    }
    
}
