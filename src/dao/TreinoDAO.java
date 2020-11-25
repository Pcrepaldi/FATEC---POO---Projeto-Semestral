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
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Exercicio;
import model.Exercicio_Treino;
import model.Treino;

/**
 *
 * @author lubuntu
 */
public class TreinoDAO {
    
    public void TreinoDAO(){
        
    }
    
    public void inserirTreino(Treino t) throws ParseException{
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {

            Statement stm = conn.createStatement();

            String adicionarTreino = "INSERT INTO treino VALUES (" + null + ", " + null + ", " + '"'+t.getNome()+'"' + ", " + '"'+t.getObjetivo()+'"' + ");";
            System.out.println(adicionarTreino);
                     
            stm.execute(adicionarTreino);
            stm.close();

            JOptionPane.showMessageDialog(null, "Treino cadastrado com sucesso!");
            //System.out.println("Aluno Cadastrado.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar no BD.");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        } finally {
          conexao.desconectar(conn);
        }
    }
   
    public int getMaxTreino() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        Treino treino = null;
        ResultSet rs = null;
        try {
            Statement stm = conn.createStatement();

            String consulta = "SELECT * FROM treino;";
            rs = stm.executeQuery(consulta);

            while(rs.next()){
                treino = new Treino();
                treino.setCod_treino(rs.getInt("cod_treino"));
            }
            
            if(!rs.isAfterLast()){
                System.out.println("ResultSet vazio.");
            }
            
            rs.close();
            stm.close();
            
        } catch (SQLException ex) {
            System.out.println("Não conseguiu pegar o MAX Treino.");
        }finally {
          conexao.desconectar(conn);
        }
        return treino.getCod_treino();
    }
    
    public void inserirExercicioTreino(int cod_exercicio){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        try {
            
            Statement stm = conn.createStatement();

            int cod = getMaxTreino();
            
            String adicionarExercicioTreino = "INSERT INTO exercicio_treino VALUES (" + null + ", " + cod + ", " + cod_exercicio + ");";
                     
            stm.execute(adicionarExercicioTreino);
            stm.close();

            
        } catch (Exception e) {
            System.out.println("Não conseguiu adicionar no BD.");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        } finally {
          conexao.desconectar(conn);
        }
    }
    
    public void inserirExercicioTreinoAlteração(int cod_exercicio, int cod_treino){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        try {
            
            Statement stm = conn.createStatement();

            //int cod = getMaxTreino();
            
            String adicionarExercicioTreino = "INSERT INTO exercicio_treino VALUES (" + null + ", " + cod_treino + ", " + cod_exercicio + ");";
            System.out.println(adicionarExercicioTreino);
            
            stm.execute(adicionarExercicioTreino);
            stm.close();

            
        } catch (Exception e) {
            System.out.println("Não conseguiu adicionar no BD.");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        } finally {
          conexao.desconectar(conn);
        }
    }
    
    public ArrayList consultarExercicioTreino(int cod_treino){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Exercicio_Treino et = null;
        ArrayList<Exercicio_Treino> exerc_treino = new ArrayList<>();
        
        try {

            String consulta = "select * from exercicio inner join exercicio_treino on exercicio.cod_exercicio = exercicio_treino.cod_exercicio where cod_treino = " + cod_treino + ";";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                et = new Exercicio_Treino();
                et.setCod_exerc(rs.getInt("COD_EXERCICIO"));
                et.setNomeEx(rs.getString("NOME"));
                et.setParte_corpo(rs.getString("PARTE_CORPO"));
                et.setQtd_series(rs.getInt("QTD_SERIES"));
                et.setParte_corpo(rs.getString("TEMPO_INTERVALO"));
                et.setCod_Exerc_Treino(rs.getInt("COD_EXERC_TREINO"));
                exerc_treino.add(et);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados do Exercicio_Treino.");
        } finally {
            conexao.desconectar(conn);
        }
        return exerc_treino;
    }
    
    public ArrayList consultarTreino() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Treino t = null;
        ArrayList<Treino> treino = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM treino;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                t = new Treino();
                t.setCod_treino(rs.getInt("COD_TREINO"));
                t.setCod_aluno(rs.getInt("COD_ALUNO"));
                t.setNome(rs.getString("NOME"));
                t.setObjetivo(rs.getString("OBJETIVO"));
                treino.add(t);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados do Treino.");
        } finally {
            conexao.desconectar(conn);
        }
        return treino;
    }
    
    public ArrayList consultarTreinoCodigo(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Treino t = null;
        ArrayList<Treino> treino = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM treino WHERE " + campo + " = " + valor + ";";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            while(rs.next()){
                t = new Treino();
                t.setCod_treino(rs.getInt("COD_TREINO"));
                t.setCod_aluno(rs.getInt("COD_ALUNO"));
                t.setNome(rs.getString("NOME"));
                t.setObjetivo(rs.getString("OBJETIVO"));
                treino.add(t);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados do Treino.");
        } finally {
            conexao.desconectar(conn);
        }
        return treino;
    }
    
    public ArrayList consultarTreinoPersonalizada(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Treino t = null;
        ArrayList<Treino> treino = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM treino WHERE " + campo + " LIKE " + "'%"+valor+"%'" + ";";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                t = new Treino();
                t.setCod_treino(rs.getInt("COD_TREINO"));
                t.setCod_aluno(rs.getInt("COD_ALUNO"));
                t.setNome(rs.getString("NOME"));
                t.setObjetivo(rs.getString("OBJETIVO"));
                treino.add(t);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException exec) {
            System.out.println("Nao conseguiu consultar os dados do Treino.");
        } finally {
            conexao.desconectar(conn);
        }
        return treino;
    }
    
    public void excluirTreino(int cod_treino){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
         try {

            String deleteExercicioTreino = "DELETE FROM exercicio_treino WHERE cod_treino = " + cod_treino + ";";
            PreparedStatement pst = conn.prepareStatement(deleteExercicioTreino);
            System.out.println(deleteExercicioTreino);
            pst.execute();
          
            pst.close();
            
            String deleteTreino = "DELETE FROM treino WHERE cod_treino = " + cod_treino + ";";
            PreparedStatement pst2 = conn.prepareStatement(deleteTreino);
            System.out.println(deleteTreino);
            pst2.execute();

            JOptionPane.showMessageDialog(null,"Treino Excluído.","",1);
          
            pst2.close();
            
            conexao.desconectar(conn);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Alerta", 2);
        }
    }
    
    public void alterarTreino(Treino treino){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        try{    
            PreparedStatement pst = conn.prepareStatement(
                "UPDATE treino " +
                "SET " +
                "    nome = ?, " +
                "    objetivo = ? " +
                "WHERE " +
                "cod_treino = ?;");
 
            pst.setString(1, treino.getNome());
            pst.setString(2, treino.getObjetivo());
            pst.setInt(3, treino.getCod_treino());
            System.out.println(pst);
            
            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+
            e.getMessage(), "Alteração de Treino", 0);
        }finally{
            conexao.desconectar(conn);
        }
    }
    
}
