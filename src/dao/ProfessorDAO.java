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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Professor;
import model.Usuario;


/**
 *
 * @author lubuntu
 */


public class ProfessorDAO {
    
    boolean auth;
    
    public ProfessorDAO(){
        
    }

    public boolean consultaLogin(String login, String senha){
        
    Conexao conexao = new Conexao();
    Connection conn = conexao.conectar();
    
    try {
        String l = '"'+login+'"';
        //System.out.println(l);
        String s = '"'+senha+'"';
        //System.out.println(s);
        String consulta = "SELECT login, senha FROM professor WHERE login = "+l+" && senha = "+s+";";
        //System.out.println(consulta);

        Statement stm = conn.createStatement();
        ResultSet resultado = stm.executeQuery(consulta);
        
        while(resultado.next()) {
            //System.out.println("login = " + resultado.getString("LOGIN"));
            //System.out.print("senha = " + resultado.getInt("SENHA") + "\n");
            if(login.equals(resultado.getString("LOGIN")) && senha.equals(resultado.getString("SENHA"))){
                System.out.println("Autenticado com sucesso!");
                auth = true;
            }
        }
        
        if(!resultado.isAfterLast()){
            System.out.println("Falha na autenticação!");
            auth = false;
        }
        
    } catch (SQLException ex) {
        System.out.println("Não conseguiu consultar os dados do Professor.");
    } finally {
        conexao.desconectar(conn);
    }
        return auth;
    }  
    
    public void inserirProfessor(Professor p, Usuario u) throws ParseException{
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {

            Statement stm1 = conn.createStatement();

            String adicionarUsuario = "INSERT INTO usuario (cod_usuario, nome, rg, cpf, email, celular, data_nasc, sexo, rua, num_casa, bairro, cidade, estado) VALUES " + "(" + null + ", " + '"'+u.getNome()+'"' + ", " + '"'+u.getRg()+'"' + ", " +
                     '"'+u.getCpf()+'"' + ", " + '"'+u.getEmail()+'"' + ", " + '"'+u.getCelular()+'"' + ", " + "'"+converteData(u.getData_nasc(), "yyyy-MM-dd")+"'" + ", " + '"'+u.getSexo()+'"' + ", " + '"'+u.getRua()+'"' + ", " + u.getNum_casa() + ", " + 
                     '"'+u.getBairro()+'"' + ", " + '"'+u.getCidade()+'"' + ", " + '"'+u.getEstado()+'"'+");";
            
            System.out.println(adicionarUsuario);
            stm1.execute(adicionarUsuario);
            System.out.println("Statement 1 OK");
            stm1.close();

            int cod = getMaxUsuario();
            System.out.println("CodMAX = " + cod);
            
            String dc = converteData(p.getData_contrato(), "yyyy-MM-dd");
            String adicionarProfessor = "insert into professor VALUES (null, " + cod + ", " + "'"+dc+"'" +", " + p.getSalario() + ", "+ '"'+p.getLogin()+'"' + ", "+'"'+p.getSenha() +'"'+ ");";
            System.out.println(adicionarProfessor);
            Statement stm2 = conn.createStatement();
            
            stm2.execute(adicionarProfessor);
            System.out.println("Statement 1 OK");
            stm2.close();
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
            System.out.println("Professor cadastrado.");
        } catch (SQLException ex) {
            System.out.println("Não conseguiu adicionar no BD.");
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        } finally {
          conexao.desconectar(conn);
        }
    }
    
    public int getMaxUsuario() throws SQLException{
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        Usuario usuario = null;
        ResultSet rs = null;
        try {
            Statement stm = conn.createStatement();

            String teste = "SELECT * FROM usuario;";
            rs = stm.executeQuery(teste);

            while(rs.next()){
                usuario = new Usuario();
                usuario.setCod_usuario(rs.getInt("cod_usuario"));
            }
            
            if(!rs.isAfterLast()){
                System.out.println("ResultSet vazio.");
            }
            
            rs.close();
            stm.close();
            
        } catch (SQLException ex) {
            System.out.println("Não conseguiu pegar o MAX.");
        }finally {
          conexao.desconectar(conn);
        }
        return usuario.getCod_usuario();
    }
    
    public String converteData(Date dataToParse, String formato) throws ParseException {
            
        Date data = dataToParse;                  
        SimpleDateFormat formatter = new SimpleDateFormat(formato);  
        
        return formatter.format(data);
    }
    
    public ArrayList consultarProfessor() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Professor p = null;
        ArrayList<Professor> prof = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM professor INNER JOIN usuario ON professor.cod_usuario = usuario.cod_usuario;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                p = new Professor();
                p.setCod_professor(rs.getInt("COD_PROFESSOR"));
                p.setCod_usuario(rs.getInt("COD_USUARIO"));
                p.setData_contrato(rs.getDate("DATA_CONTRATO"));
                p.setSalario(rs.getDouble("SALARIO"));
                p.setLogin(rs.getString("LOGIN"));
                p.setSenha(rs.getString("SENHA"));
                p.setNome(rs.getString("NOME"));
                p.setRg(rs.getString("RG"));
                p.setCpf(rs.getString("CPF"));
                p.setEmail(rs.getString("EMAIL"));
                p.setCelular(rs.getString("CELULAR"));
                p.setData_nasc(rs.getDate("DATA_NASC"));
                p.setSexo(rs.getString("SEXO"));
                p.setRua(rs.getString("RUA"));
                p.setNum_casa(rs.getInt("NUM_CASA"));
                p.setBairro(rs.getString("BAIRRO"));
                p.setCidade(rs.getString("CIDADE"));
                p.setEstado(rs.getString("ESTADO"));
                prof.add(p);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu consultar os dados do Professor/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return prof;
    }
    
    public ArrayList consultarProfessorPersonalizada(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Professor p = null;
        ArrayList<Professor> prof = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM professor INNER JOIN usuario ON professor.cod_usuario = usuario.cod_usuario WHERE " + campo + " LIKE " +"'%"+valor+"%'"+ ";";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                p = new Professor();
                p.setCod_professor(rs.getInt("COD_PROFESSOR"));
                p.setCod_usuario(rs.getInt("COD_USUARIO"));
                p.setData_contrato(rs.getDate("DATA_CONTRATO"));
                p.setSalario(rs.getDouble("SALARIO"));
                p.setLogin(rs.getString("LOGIN"));
                p.setSenha(rs.getString("SENHA"));
                p.setNome(rs.getString("NOME"));
                p.setRg(rs.getString("RG"));
                p.setCpf(rs.getString("CPF"));
                p.setEmail(rs.getString("EMAIL"));
                p.setCelular(rs.getString("CELULAR"));
                p.setData_nasc(rs.getDate("DATA_NASC"));
                p.setSexo(rs.getString("SEXO"));
                p.setRua(rs.getString("RUA"));
                p.setNum_casa(rs.getInt("NUM_CASA"));
                p.setBairro(rs.getString("BAIRRO"));
                p.setCidade(rs.getString("CIDADE"));
                p.setEstado(rs.getString("ESTADO"));
                prof.add(p);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu realizar a consulta personalizada dos dados do Professor/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return prof;
    }
    
    public ArrayList consultarProfessorCodigo(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Professor p = null;
        ArrayList<Professor> prof = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM professor INNER JOIN usuario ON professor.cod_usuario = usuario.cod_usuario WHERE " + campo + " = " +"'"+valor+"'"+ ";";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            
            while(rs.next()){
                p = new Professor();
                p.setCod_professor(rs.getInt("COD_PROFESSOR"));
                p.setCod_usuario(rs.getInt("COD_USUARIO"));
                p.setData_contrato(rs.getDate("DATA_CONTRATO"));
                p.setSalario(rs.getDouble("SALARIO"));
                p.setLogin(rs.getString("LOGIN"));
                p.setSenha(rs.getString("SENHA"));
                p.setNome(rs.getString("NOME"));
                p.setRg(rs.getString("RG"));
                p.setCpf(rs.getString("CPF"));
                p.setEmail(rs.getString("EMAIL"));
                p.setCelular(rs.getString("CELULAR"));
                p.setData_nasc(rs.getDate("DATA_NASC"));
                p.setSexo(rs.getString("SEXO"));
                p.setRua(rs.getString("RUA"));
                p.setNum_casa(rs.getInt("NUM_CASA"));
                p.setBairro(rs.getString("BAIRRO"));
                p.setCidade(rs.getString("CIDADE"));
                p.setEstado(rs.getString("ESTADO"));
                prof.add(p);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu realizar a consulta personalizada dos dados do Professor/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return prof;
    }

    public boolean executarDML(String dml) {
        boolean executado = false;

        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        try {
            Statement stm = conn.createStatement();
            stm.execute(dml);
            executado = true;
        } catch (SQLException ex) {
            System.out.println("Nao conseguiu executar o DML\n" + dml);
        } finally {
          conexao.desconectar(conn);
        }

        return executado;
      }
    
    public void alterarProfessor(Professor prof){
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
    try{    
          PreparedStatement pst = conn.prepareStatement(
                      "UPDATE usuario " +
                      "SET " +
                      "    nome = ?, " +
                      "    rg = ?, " +
                      "    cpf = ?, " +
                      "    email = ?, " +
                      "    data_nasc = ?, " +
                      "    celular = ?, " +
                      "    sexo = ? ," +
                      "    rua = ?, " +
                      "    num_casa = ?, " +
                      "    bairro = ?, " +
                      "    cidade = ?, " +
                      "    estado = ? " +
                      "WHERE " +
                      "cod_usuario = ?;");
          
              DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
              String dataNascimentoFormatada = dateFormat.format(prof.getData_nasc());
              
              pst.setString(1, prof.getNome());
              pst.setString(2, prof.getRg());
              pst.setString(3, prof.getCpf());
              pst.setString(4, prof.getEmail());
              pst.setString(5, dataNascimentoFormatada);
              pst.setString(6, prof.getCelular());
              pst.setString(7, prof.getSexo());
              pst.setString(8, prof.getRua());
              pst.setInt(9, prof.getNum_casa());
              pst.setString(10, prof.getBairro());
              pst.setString(11, prof.getCidade());
              pst.setString(12, prof.getEstado());
              pst.setInt(13, prof.getCod_usuario());

              pst.execute();
              pst.close();

              JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
        } catch(SQLException e){
             JOptionPane.showMessageDialog(null, "ERRO..."+
                e.getMessage(), "Alteração de professores", 0);
        }finally{
            conexao.desconectar(conn);
        }
    }
    
    public void excluirProfessor(Professor prof) {
        String delete = "DELETE FROM professor WHERE cod_usuario = " + prof.getCod_usuario()+ ";";
        String delete2 = "DELETE FROM usuario WHERE cod_usuario = " + prof.getCod_usuario()+ ";";
        
        System.out.println(delete);
        
        executarDML(delete);
        executarDML(delete2);
        
        JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
    }
    
}
