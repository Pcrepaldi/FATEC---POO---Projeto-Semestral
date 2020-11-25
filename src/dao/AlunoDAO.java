/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author lubuntu
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Usuario;

/**
 * Classe utilizada para demonstrar a consulta ao banco de dados.
 */
public class AlunoDAO {

    public ArrayList consultarAluno() {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Aluno a = null;
        ArrayList<Aluno> aluno = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM aluno INNER JOIN usuario ON aluno.cod_usuario = usuario.cod_usuario;";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                a = new Aluno();
                a.setCod_aluno(rs.getInt("COD_ALUNO"));
                a.setCod_usuario(rs.getInt("COD_USUARIO"));
                a.setPeso(rs.getDouble("PESO"));
                a.setAltura(rs.getDouble("ALTURA"));
                a.setValor_mensalidade(rs.getDouble("VALOR_MENSALIDADE"));
                a.setData_vencimento(rs.getDate("DATA_VENCIMENTO"));
                a.setData_inicio(rs.getDate("DATA_INICIO"));
                a.setAtivo(rs.getBoolean("ATIVO"));
                a.setNome(rs.getString("NOME"));
                a.setRg(rs.getString("RG"));
                a.setCpf(rs.getString("CPF"));
                a.setEmail(rs.getString("EMAIL"));
                a.setCelular(rs.getString("CELULAR"));
                a.setData_nasc(rs.getDate("DATA_NASC"));
                a.setSexo(rs.getString("SEXO"));
                a.setRua(rs.getString("RUA"));
                a.setNum_casa(rs.getInt("NUM_CASA"));
                a.setBairro(rs.getString("BAIRRO"));
                a.setCidade(rs.getString("CIDADE"));
                a.setEstado(rs.getString("ESTADO"));
                aluno.add(a);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu consultar os dados do Aluno/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return aluno;
    }
  
    public ArrayList consultarAlunoPersonalizada(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Aluno a = null;
        ArrayList<Aluno> aluno = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM aluno INNER JOIN usuario ON aluno.cod_usuario = usuario.cod_usuario WHERE " + campo + " LIKE " +"'%"+valor+"%'"+ ";";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                a = new Aluno();
                a.setCod_aluno(rs.getInt("COD_ALUNO"));
                a.setCod_usuario(rs.getInt("COD_USUARIO"));
                a.setPeso(rs.getDouble("PESO"));
                a.setAltura(rs.getDouble("ALTURA"));
                a.setValor_mensalidade(rs.getDouble("VALOR_MENSALIDADE"));
                a.setData_vencimento(rs.getDate("DATA_VENCIMENTO"));
                a.setData_inicio(rs.getDate("DATA_INICIO"));
                a.setAtivo(rs.getBoolean("ATIVO"));
                a.setNome(rs.getString("NOME"));
                a.setRg(rs.getString("RG"));
                a.setCpf(rs.getString("CPF"));
                a.setEmail(rs.getString("EMAIL"));
                a.setCelular(rs.getString("CELULAR"));
                a.setData_nasc(rs.getDate("DATA_NASC"));
                a.setSexo(rs.getString("SEXO"));
                a.setRua(rs.getString("RUA"));
                a.setNum_casa(rs.getInt("NUM_CASA"));
                a.setBairro(rs.getString("BAIRRO"));
                a.setCidade(rs.getString("CIDADE"));
                a.setEstado(rs.getString("ESTADO"));
                aluno.add(a);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu realizar a consulta personalizada dos dados do Aluno/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return aluno;
    }
    
    public ArrayList consultarAlunoAtivo(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Aluno a = null;
        ArrayList<Aluno> aluno = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM aluno INNER JOIN usuario ON aluno.cod_usuario = usuario.cod_usuario WHERE " + campo + " = " +valor+ ";";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                a = new Aluno();
                a.setCod_aluno(rs.getInt("COD_ALUNO"));
                a.setCod_usuario(rs.getInt("COD_USUARIO"));
                a.setPeso(rs.getDouble("PESO"));
                a.setAltura(rs.getDouble("ALTURA"));
                a.setValor_mensalidade(rs.getDouble("VALOR_MENSALIDADE"));
                a.setData_vencimento(rs.getDate("DATA_VENCIMENTO"));
                a.setData_inicio(rs.getDate("DATA_INICIO"));
                a.setAtivo(rs.getBoolean("ATIVO"));
                a.setNome(rs.getString("NOME"));
                a.setRg(rs.getString("RG"));
                a.setCpf(rs.getString("CPF"));
                a.setEmail(rs.getString("EMAIL"));
                a.setCelular(rs.getString("CELULAR"));
                a.setData_nasc(rs.getDate("DATA_NASC"));
                a.setSexo(rs.getString("SEXO"));
                a.setRua(rs.getString("RUA"));
                a.setNum_casa(rs.getInt("NUM_CASA"));
                a.setBairro(rs.getString("BAIRRO"));
                a.setCidade(rs.getString("CIDADE"));
                a.setEstado(rs.getString("ESTADO"));
                aluno.add(a);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu realizar a consulta personalizada dos dados do Aluno/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return aluno;
    }
    
    public ArrayList consultarAlunoCodigo(String campo, String valor) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        
        Aluno a = null;
        ArrayList<Aluno> aluno = new ArrayList<>();
        
        try {

            String consulta = "SELECT * FROM aluno INNER JOIN usuario ON aluno.cod_usuario = usuario.cod_usuario WHERE " + campo + " = " + valor +";";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);
            System.out.println(consulta);
            
            while(rs.next()){
                a = new Aluno();
                a.setCod_aluno(rs.getInt("COD_ALUNO"));
                a.setCod_usuario(rs.getInt("COD_USUARIO"));
                a.setPeso(rs.getDouble("PESO"));
                a.setAltura(rs.getDouble("ALTURA"));
                a.setValor_mensalidade(rs.getDouble("VALOR_MENSALIDADE"));
                a.setData_vencimento(rs.getDate("DATA_VENCIMENTO"));
                a.setData_inicio(rs.getDate("DATA_INICIO"));
                a.setAtivo(rs.getBoolean("ATIVO"));
                a.setNome(rs.getString("NOME"));
                a.setRg(rs.getString("RG"));
                a.setCpf(rs.getString("CPF"));
                a.setEmail(rs.getString("EMAIL"));
                a.setCelular(rs.getString("CELULAR"));
                a.setData_nasc(rs.getDate("DATA_NASC"));
                a.setSexo(rs.getString("SEXO"));
                a.setRua(rs.getString("RUA"));
                a.setNum_casa(rs.getInt("NUM_CASA"));
                a.setBairro(rs.getString("BAIRRO"));
                a.setCidade(rs.getString("CIDADE"));
                a.setEstado(rs.getString("ESTADO"));
                aluno.add(a);
            }
            
            stm.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println("Nao conseguiu realizar a consulta de código dos dados do Aluno/Usuario.");
        } finally {
            conexao.desconectar(conn);
        }
        return aluno;
    }
  
    public void inserirAluno(Aluno a, Usuario u) throws ParseException{
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();

        try {

            ProfessorDAO pDAO = new ProfessorDAO();
            Statement stm1 = conn.createStatement();

            String adicionarUsuario = "INSERT INTO usuario (cod_usuario, nome, rg, cpf, email, celular, data_nasc, sexo, rua, num_casa, bairro, cidade, estado) VALUES " + "(" + null + ", " + '"'+u.getNome()+'"' + ", " + '"'+u.getRg()+'"' + ", " +
                     '"'+u.getCpf()+'"' + ", " + '"'+u.getEmail()+'"' + ", " + '"'+u.getCelular()+'"' + ", " + "'"+pDAO.converteData(u.getData_nasc(), "yyyy-MM-dd")+"'" + ", " + '"'+u.getSexo()+'"' + ", " + '"'+u.getRua()+'"' + ", " + u.getNum_casa() + ", " + 
                     '"'+u.getBairro()+'"' + ", " + '"'+u.getCidade()+'"' + ", " + '"'+u.getEstado()+'"'+");";

            //System.out.println(adicionarUsuario);
            stm1.execute(adicionarUsuario);
            //System.out.println("Statement 1 OK");
            stm1.close();

            int cod = getMaxUsuario();
            //System.out.println("CodMAX = " + cod);

            String dataVen = pDAO.converteData(a.getData_vencimento(), "yyyy-MM-dd");
            String dataIni = pDAO.converteData(a.getData_inicio(), "yyyy-MM-dd");
            
            String adicionarAluno = "INSERT INTO aluno VALUES (null, " + cod + ", " + a.getPeso() + ", " + a.getAltura() + ", " + a.getValor_mensalidade() + ", " + "'"+dataVen+"'" + ", " + "'"+dataIni+"'" +", " + a.getAtivo() + ");";
            //System.out.println(adicionarAluno);
            
            Statement stm2 = conn.createStatement();
            stm2.execute(adicionarAluno);
            //System.out.println("Statement 2 OK");
            
            stm2.close();
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            //System.out.println("Aluno Cadastrado.");
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
  
    public void alterarAluno(Aluno aluno){
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
              String dataNascimentoFormatada = dateFormat.format(aluno.getData_nasc());
              
              pst.setString(1, aluno.getNome());
              pst.setString(2, aluno.getRg());
              pst.setString(3, aluno.getCpf());
              pst.setString(4, aluno.getEmail());
              pst.setString(5, dataNascimentoFormatada);
              pst.setString(6, aluno.getCelular());
              pst.setString(7, aluno.getSexo());
              pst.setString(8, aluno.getRua());
              pst.setInt(9, aluno.getNum_casa());
              pst.setString(10, aluno.getBairro());
              pst.setString(11, aluno.getCidade());
              pst.setString(12, aluno.getEstado());
              pst.setInt(13, aluno.getCod_usuario());

              pst.execute();
              pst.close();

              JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso.");
        } catch(SQLException e){
             JOptionPane.showMessageDialog(null, "ERRO..."+
                e.getMessage(), "Alteração de alunos", 0);
        }finally{
            conexao.desconectar(conn);
        }
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
    
    public void excluirAluno(Aluno aluno) {
        String delete = "DELETE FROM aluno WHERE cod_usuario = " + aluno.getCod_usuario()+ ";";
        String delete2 = "DELETE FROM usuario WHERE cod_usuario = " + aluno.getCod_usuario()+ ";";
        
        System.out.println(delete);
        
        executarDML(delete);
        executarDML(delete2);
        
        JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
    }
  
}