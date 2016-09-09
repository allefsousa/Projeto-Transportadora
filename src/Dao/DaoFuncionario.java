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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
public class DaoFuncionario {

    ConnBanco ConnFunc = new ConnBanco();
    public String chaveEstrangeira(String sql,int idChave){
        try {
            String resultado = null;
            
           // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            ConnFunc.conn = ConnFunc.getConection();
            ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setInt(1, idChave);
            ResultSet rs = ConnFunc.pstm.executeQuery();
            if (rs.next()) {
                resultado=(rs.getString(1));
            }
            
            
            return resultado;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        return null;
    }
    public boolean insereFuncionario(Funcionario funcionario) {
        ConnFunc.conn = ConnFunc.getConection();
        String InsereFucionario = " INSERT INTO funcionario(cpf, nome, rg, dataNAsc,"
                + "cargo, cep, rua, "
                + "numero, bairro, complemento, estado, dataRegistro, fone, fk_Cnpj_Centro_Dist, fk_Cidade_Func)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            comando.setString(5, funcionario.getFuncao());
            comando.setInt(6, funcionario.getCep());
            comando.setString(7, funcionario.getEndereco());
            comando.setInt(8, funcionario.getNumero());
            comando.setString(9, funcionario.getBairro());
            comando.setString(10, funcionario.getComplemento());
            comando.setString(11, funcionario.getEstado());
            comando.setString(12, formatter.format(funcionario.getDataRegistro()));
            comando.setInt(13, funcionario.getTelCelular());
            comando.setInt(14, funcionario.getCnpjTransp());
            comando.setInt(15, funcionario.getCidadeFunciCentro());
            // Implememtar a classe empresa  comando.setInt(17, funcionario.getCnpjTransp());

            //executa a query
            comando.execute();
            //Fecha a conexao com o BD
            ConnFunc.conn.close();
            JOptionPane.showMessageDialog(null, "Funcionario Inserido Com Sucesso !! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Persistir" + e);
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
            ConnFunc.pstm.setString(9, funcionario.getEndereco());
            ConnFunc.pstm.setInt(10, funcionario.getNumero());
            ConnFunc.pstm.setString(11, funcionario.getBairro());
            ConnFunc.pstm.setString(12, funcionario.getComplemento());
    
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
            String sql = "SELECT id FROM funcionario WHERE id = ?";
            ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setInt(1, funcionario.getNumMatricula());
            ResultSet rs = ConnFunc.pstm.executeQuery();

            if (rs.next()) {
                sql = "DELETE FROM funcionario WHERE id = ?";
                ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
                //ConnFunc.pstm.setString(1, (String.valueOf(funcionario.getNumMatricula())));
                ConnFunc.pstm.setInt(1, funcionario.getNumMatricula());
                ConnFunc.pstm.execute();
                JOptionPane.showMessageDialog(null, "Funcionario Removido Com Sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionario não existe !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Remover Funcionario");
            e.printStackTrace();
        }
        return false;
    }

    public Funcionario getFuncionario(int codigo) {
        String SqlEstrageira,retorn;
         int cidade, centrodis;
        try {
           
            ConnFunc.conn = ConnFunc.getConection();
            //  JOptionPane.showMessageDialog(null, ""+ codigo);
            DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String sql = ("SELECT id,cpf, nome, rg, dataNasc, cargo, cep, rua, numero, bairro, complemento, estado, dataRegistro, fone, fk_Cnpj_Centro_Dist, Fk_Cidade_Func FROM transportadora.funcionario WHERE id= ?;");
            ConnFunc.pstm = ConnFunc.conn.prepareStatement(sql);
            ConnFunc.pstm.setInt(1, codigo);
            // recebendo os resultados do select  e executando a tarefa 
            ResultSet rs = ConnFunc.pstm.executeQuery();
            Model.Funcionario f = new Funcionario();
            if (rs.next()) {

                f.setNumMatricula((rs.getInt(1)));
                f.setCpf(rs.getString(2));
                f.setNome(rs.getString(3));
                f.setRg(String.valueOf(rs.getInt(4)));
                f.setDataNasc((rs.getDate(5)));
                f.setFuncao(rs.getString(6));
                f.setCep(rs.getInt(7));
                f.setEndereco(rs.getString(8));
                f.setNumero(rs.getInt(9));
                f.setBairro(rs.getString(10));
                f.setComplemento(rs.getString(11));
            
                f.setEstado(rs.getString(12));
                f.setDataRegistro(rs.getDate(13));
                f.setTelCelular(rs.getInt(14));
               /* centrodis = rs.getInt(15);
                SqlEstrageira = "SELECT nome_Fantasia FROM centro_dist WHERE cnpj=?";
               retorn = chaveEstrangeira(SqlEstrageira, centrodis);
               JOptionPane.showMessageDialog(null, retorn);
               */
                f.setCnpjTransp(rs.getInt(15));
                
                f.setCidadeFunciCentro(rs.getInt(16));
                // verificar bug da mensagem quando nao existe essa mensagem logo abaixo  da erro 
                //com essa mensagem nao 
                JOptionPane.showMessageDialog(null, "");

            }
            return f;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar funcionario!" + e.getMessage());
        }
        return null;
    }
}
