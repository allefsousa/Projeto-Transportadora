/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.CentroDistribuicao;
import Model.Empresa;
import Model.Funcionario;
import Model.ModelEmpresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
public class DaoEmpresa {
     ConnBanco ConnEmpresa = new ConnBanco();

    public String chaveEstrangeira(String sql, int idChave) {
        try {
            String resultado = null;

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            ConnEmpresa.conn = ConnEmpresa.getConection();
            ConnEmpresa.pstm = ConnEmpresa.conn.prepareStatement(sql);
            ConnEmpresa.pstm.setInt(1, idChave);
            ResultSet rs = ConnEmpresa.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString(1));
            }

            return resultado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        return null;
    }

    public String chaveEstrangeiraLong(String sql, Long idChave) {
        try {
            String resultado = null;

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            ConnEmpresa.conn = ConnEmpresa.getConection();
            ConnEmpresa.pstm = ConnEmpresa.conn.prepareStatement(sql);
            ConnEmpresa.pstm.setLong(1, idChave);
            ResultSet rs = ConnEmpresa.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString(1));
            }

            return resultado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras" + ex.getMessage());
        }
        return null;
    }

    public boolean insereEmpresa(CentroDistribuicao centroDistribuicao) {
        ConnEmpresa.conn = ConnEmpresa.getConection();
        String InsereFucionario = " INSERT INTO centro_dist()"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement comando = ConnEmpresa.conn.prepareStatement(InsereFucionario);
            // formatar a query 
            comando.setString(1, centroDistribuicao.getCnpj());
            comando.setString(2, centroDistribuicao.getRazaosocial());
            comando.setString(3, centroDistribuicao.getNomeFantasia());
           
            comando.setString(4, centroDistribuicao.getEmailTransp());
            comando.setString(5, centroDistribuicao.getRuaTransp());
            comando.setString(6, centroDistribuicao.getNumeroTransp());
            comando.setString(7, centroDistribuicao.getBairroTransp());
            comando.setInt(8, centroDistribuicao.getCepTransp());
            comando.setString(9, centroDistribuicao.getFone());
            comando.setInt(10, centroDistribuicao.getCidade());
            
           
            // Implememtar a classe empresa  comando.setInt(17, funcionario.getCnpjTransp());

            //executa a query
            comando.execute();
            //Fecha a conexao com o BD
            ConnEmpresa.conn.close();
            JOptionPane.showMessageDialog(null, "Filial Cadastrada Com Sucesso !! ");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Persistir" + e);
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizarEmp(CentroDistribuicao centroDistribuicao) {

        try {
            ConnEmpresa.conn = ConnEmpresa.getConection();
            String sql = "UPDATE centro_dist SET nome_Fantasia = ?, email_Transp = ?, email_Transp = ?, "
                    + " rua_Transp = ?, numero_Transp = ?,bairro_Transp = ?"
                    + ",cep_Transp = ?, fone = ? ,fk_Id_Cidade = ?"
                    + "WHERE cnpj=? ";
            
           PreparedStatement comando = ConnEmpresa.conn.prepareStatement(sql);
            // formatar a query 
            
            comando.setString(1, centroDistribuicao.getRazaosocial());
            comando.setString(2, centroDistribuicao.getNomeFantasia());
           
            comando.setString(3, centroDistribuicao.getEmailTransp());
            comando.setString(4, centroDistribuicao.getRuaTransp());
            comando.setString(5, centroDistribuicao.getNumeroTransp());
            comando.setString(6, centroDistribuicao.getBairroTransp());
            comando.setInt(7, centroDistribuicao.getCepTransp());
            comando.setString(8, centroDistribuicao.getFone());
            comando.setInt(9, centroDistribuicao.getCidade());
           comando.setString(10, centroDistribuicao.getCnpj());
            //executa a query
            ConnEmpresa.pstm.execute();
            ConnEmpresa.conn.close();
            JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso !");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Empresa!" +e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletarEmp(CentroDistribuicao centroDistribuicao) {
        try {
            ConnEmpresa.conn = ConnEmpresa.getConection();
            String sql = "SELECT cnpj FROM centro_dist WHERE cnpj = ?";
            ConnEmpresa.pstm = ConnEmpresa.conn.prepareStatement(sql);
            ConnEmpresa.pstm.setString(1, centroDistribuicao.getCnpj());
            ResultSet rs = ConnEmpresa.pstm.executeQuery();

            if (rs.next()) {
                sql = "DELETE FROM centro_dist WHERE cnpj = ?";
                ConnEmpresa.pstm = ConnEmpresa.conn.prepareStatement(sql);
                //ConnFunc.pstm.setString(1, (String.valueOf(funcionario.getNumMatricula())));
                ConnEmpresa.pstm.setString(1, centroDistribuicao.getCnpj());
                ConnEmpresa.pstm.execute();
                JOptionPane.showMessageDialog(null, "Filial Removido Com Sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Filial não existe !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Remover Filial !");
            e.printStackTrace();
        }
        return false;
    }

    public CentroDistribuicao getEmp(String codigo) {

        try {

            ConnEmpresa.conn = ConnEmpresa.getConection();
            //  JOptionPane.showMessageDialog(null, ""+ codigo);
            DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String sql = ("SELECT cnpj,razao_Social, nome_Fantasia, email_Transp, rua_Transp, numero_Transp, bairro_Transp, cep_Transp, fone FROM centro_dist WHERE cnpj= ?;");
            ConnEmpresa.pstm = ConnEmpresa.conn.prepareStatement(sql);
            ConnEmpresa.pstm.setString(1, codigo);
            // recebendo os resultados do select  e executando a tarefa 
            ResultSet rs = ConnEmpresa.pstm.executeQuery();
            Model.CentroDistribuicao f = new CentroDistribuicao();
            if (rs.next()) {

                f.setCnpj(rs.getString(1));
                f.setRazaosocial(rs.getString(2));
                f.setNomeFantasia(rs.getString(3));
                f.setEmailTransp((rs.getString(4)));
                f.setRuaTransp((rs.getString(5)));
                f.setNumeroTransp(rs.getString(6));
                f.setBairroTransp(rs.getString(7));
                f.setCepTransp(rs.getInt(8));
                f.setFone(rs.getString(9));
                f.setCidade(rs.getInt(10));
                // verificar bug da mensagem quando nao existe essa mensagem logo abaixo  da erro 
                //com essa mensagem nao 
                JOptionPane.showMessageDialog(null, "Registros Retornados Com Sucesso");
                return f;
            }
            return f;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar funcionario!" + e.getMessage());
        }
        return null;
    }
}
