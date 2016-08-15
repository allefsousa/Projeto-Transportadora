/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Funcionario;
import static java.lang.System.console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
public class DaoFuncionario {

    ConnBanco ConnFunc = new ConnBanco();

    public boolean insereFuncionario(Funcionario funcionario) {
        ConnFunc.conn = ConnFunc.getConection();
        String InsereFucionario = " INSERT INTO funcionario(cpf, nome, rg, dataNAsc,salario,"
                + "nomeUsuario, senha, cargo, cep, rua, "
                + "numero, bairro, complemento, cidade, estado, dataRegistro)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement comando = ConnFunc.conn.prepareStatement(InsereFucionario);
            // formatar a query 
            comando.setString(1, funcionario.getCpf());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getRg());
            //Formatando a data para ano mes e dia           
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            //Inserindo o valor formatado no banco
            comando.setString(4, formatter.format(funcionario.getDataNasc()));
           comando.setString(5,String.valueOf(( funcionario.getSalario())));
            comando.setString(6, funcionario.getNomeUsuario());
            comando.setString(7, funcionario.getSenha());
            comando.setString(8, funcionario.getFuncao());
            comando.setInt(9, funcionario.getCep());
            comando.setString(10, funcionario.getEndereco());
            comando.setInt(11, funcionario.getNumero());
            comando.setString(12, funcionario.getBairro());
            comando.setString(13, funcionario.getComplemento());
            comando.setString(14, funcionario.getCidade());
            comando.setString(15, funcionario.getEstado());
            comando.setString(16, formatter.format(funcionario.getDataRegistro()));
          // Implememtar a classe empresa  comando.setInt(17, funcionario.getCnpjTransp());

            //executa a query
            comando.execute();
            //Fecha a conexao com o BD
            ConnFunc.conn.close();
            JOptionPane.showMessageDialog(null,"Funcionario Inserido Com Sucesso !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Impossivel Persistir"+ e);
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizarFunc(Funcionario funcionario) {

        try {
            ConnFunc.conn = ConnFunc.getConection();
            String sql = "UPDATE funcionario set cpf = ?, nome = ?, rg = ?, dataNasc = ?, "
                    + "nomeUsuario = ?, senha = ?, cargo = ?, cep = ?, rua = ?"
                    + "numero = ?, bairro = ? complemento = ?, cidade = ?, estado = ?,"
                    + "dataRegistro = ?";
            ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setString(1, funcionario.getCpf());
            ConnFunc.pstm.setString(2, funcionario.getNome());
            ConnFunc.pstm.setString(3, funcionario.getRg());
            //Formatando a data para ano mes e dia 
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            ConnFunc.pstm.setString(4, formatter.format(funcionario.getDataNasc()));
            ConnFunc.pstm.setString(5, funcionario.getNomeUsuario());
            ConnFunc.pstm.setString(6, funcionario.getSenha());
            ConnFunc.pstm.setString(7, funcionario.getFuncao());
            ConnFunc.pstm.setInt(8, funcionario.getCep());
            ConnFunc.pstm.setString(9, funcionario.getRua());
            ConnFunc.pstm.setInt(10, funcionario.getNumero());
            ConnFunc.pstm.setString(11, funcionario.getBairro());
            ConnFunc.pstm.setString(12, funcionario.getComplemento());
            ConnFunc.pstm.setString(13, funcionario.getCidade());
            ConnFunc.pstm.setString(14, funcionario.getEstado());
            ConnFunc.pstm.setString(15, formatter.format(funcionario.getDataRegistro()));
            ConnFunc.pstm.setInt(16, funcionario.getCnpjTransp());
            //executa a query
            ConnFunc.pstm.execute();
            ConnFunc.conn.close();
            JOptionPane.showMessageDialog(null, "Funcionario atualizado com sucesso !");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionario!");
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletarFunc(Funcionario funcionario) {
        try {
            ConnFunc.conn = ConnFunc.getConection();
            String sql = "DELETE FROM funcionario WHERE id = ?";
            ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setString(1, (String.valueOf(funcionario.getNumMatricula())));
            ConnFunc.pstm.execute();
            JOptionPane.showMessageDialog(null, "Funcionario Removido Com Sucesso");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Remover Funcionario");
            e.printStackTrace();
        }
        return false;
    }
    
  /*  public Funcionario getFuncionario(int cpf){
        try {
            ConnFunc.conn = ConnFunc.getConection();
            
            //DateFormat format = new SimpleDateFormat("ddmmyyyy");
            String sql = "SELECT * FROM funcionario where cpf = ?";
            ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setInt(1, cpf);
            ConnFunc.rs = ConnFunc.pstm.executeQuery();
            if(ConnFunc.rs.next()){
                Funcionario f = new Funcionario();
                
                f.setCpf(ConnFunc.rs.getString(1));
                f.setNome(ConnFunc.rs.getString(2));
                f.setRg((ConnFunc.rs.getString(3)));
                f.setDataNasc(ConnFunc.rs.getDate(4));
                f.setNomeUsuario(ConnFunc.rs.getString(5));
                f.setSenha(ConnFunc.rs.getString(6));
                f.setFuncao(ConnFunc.rs.getString(7));
                f.setCep(Integer.parseInt(ConnFunc.rs.getString(8)));
                f.setRua(ConnFunc.rs.getString(9));
                f.setNumero(Integer.parseInt(ConnFunc.rs.getString(10)));
                f.setBairro(ConnFunc.rs.getString(11));
                f.setComplemento(ConnFunc.rs.getString(12));
                f.setCidade(ConnFunc.rs.getString(13));
                f.setEstado(ConnFunc.rs.getString(14));
                f.setDataRegistro(ConnFunc.rs.getDate(15));
                f.setCnpjTransp(Integer.parseInt(ConnFunc.rs.getString(16)));
                
                ConnFunc.conn.close();
                
                return f;
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog
                    (null,"Erro ao recuperar Funcionario!" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }*/
     public Funcionario getFuncionario(int codigo){
        try {
            
           ConnFunc.conn = ConnFunc.getConection();
          //  JOptionPane.showMessageDialog(null, ""+ codigo);
            DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
           String sql = ( "SELECT id,cpf, nome, rg, dataNAsc, salario, nomeUsuario, senha, cargo, cep, rua, numero, bairro, complemento, cidade, estado, dataRegistro FROM transportadora.funcionario WHERE id= ?;");
            ConnFunc.pstm=ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setInt(1, codigo);
            // recebendo os resultados do select  e executando a tarefa 
            ResultSet rs = ConnFunc.pstm.executeQuery();
            Model.Funcionario f= new Funcionario();
            if (rs.next()) {
                
               
                f.setNumMatricula((rs.getInt(1)));
                f.setCpf(rs.getString(2));
                f.setNome(rs.getString(3));
                f.setRg(String.valueOf(rs.getInt(4)));
                f.setDataNasc((rs.getDate(5)));
                f.setSalario(Double.valueOf(rs.getString(6)));
                f.setNomeUsuario(rs.getString(7));
                f.setSenha(rs.getString(8));
                f.setFuncao(rs.getString(9));
                f.setCep(rs.getInt(10));
                f.setEndereco(rs.getString(11));
                f.setNumero(rs.getInt(12));
                f.setBairro(rs.getString(13));
                f.setComplemento(rs.getString(14));
                f.setCidade(rs.getString(15));
                f.setEstado(rs.getString(16));
                f.setDataRegistro(rs.getDate(17));
               // verificar bug da mensagem quando nao existe essa mensagem logo abaixo  da erro 
               //com essa mensagem nao 
               JOptionPane.showMessageDialog(null, "");
             
                
               
                
                 
            }
            return f;
        } catch (Exception e) {
            JOptionPane.showMessageDialog
                    (null,"Erro ao recuperar funcionario!" + e.getMessage());
        }
        return null;
    }
}
