/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Funcionario;
import Model.modelRota;
import com.sun.swing.internal.plaf.metal.resources.metal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allef
 */
public class DaoRota {

    ConnBanco connrota = new ConnBanco();
    modelRota modelrota = new Model.modelRota();
    ConnBanco ConRota = new ConnBanco();
    
    public String chaveEstrangeira(String sql, int idChave) {
        try {
            String resultado = null;

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            ConRota.conn = ConRota.getConection();
            ConRota.pstm = ConRota.conn.prepareStatement(sql);
            ConRota.pstm.setInt(1, idChave);
            ResultSet rs = ConRota.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString(1));
            }
            
            ConRota.conn.close();

            return resultado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        return null;
    }

    public boolean insereRota(modelRota rota) {
        connrota.conn = connrota.getConection();
        String InsereRota = " INSERT INTO rota(qtd_Dias, valor_Rota,fk_Id_Cidade_Origem, fk_Id_Cidade_Destino, descricao_Rota)"
                + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement comando = connrota.conn.prepareStatement(InsereRota);
            // formatar a query 
            comando.setInt(1, rota.getQuantdias());
            comando.setFloat(2, rota.getValorRota());
            comando.setInt(3, rota.getIdCidadeOrigem());
            comando.setInt(4, rota.getIdCidadeDestino());
            comando.setString(5, rota.getDescricaoRota());
            
            //executa a query
            comando.execute();
            //Fecha a conexao com o BD
            connrota.conn.close();
            JOptionPane.showMessageDialog(null, "Rota Inserida Com Sucesso !! ");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Persistir" + e);
            e.printStackTrace();
        }

        return false;
    }

    public boolean atualizarRota(modelRota rota) {

        try {
            connrota.conn = connrota.getConection();
            String sql = "UPDATE rota set  qtd_Dias = ?, valor_Rota = ?, fk_Id_Cidade_Origem, fk_Id_Cidade_Destino, descricao_Rota = ? where numero_Rota =? ";

            connrota.pstm = connrota.conn.prepareStatement(sql);

            connrota.pstm.setInt(1, rota.getQuantdias());
            connrota.pstm.setFloat(2, rota.getValorRota());
            connrota.pstm.setInt(3, rota.getIdCidadeOrigem());
            connrota.pstm.setInt(4, rota.getIdCidadeDestino());
            connrota.pstm.setString(5, rota.getDescricaoRota());
            connrota.pstm.setInt(6, rota.getNumrota());

            //executa a query
            connrota.pstm.execute();
            connrota.conn.close();
            JOptionPane.showMessageDialog(null, "Rota atualizada com sucesso !");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Rota!" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletarRota(modelRota rota) {
        try {
            connrota.conn = connrota.getConection();
            String sql = "SELECT numero_Rota FROM rota WHERE numero_Rota = ?";
            connrota.pstm = connrota.conn.prepareStatement(sql);
            connrota.pstm.setInt(1, rota.getNumrota());
            ResultSet rs = connrota.pstm.executeQuery();

            if (rs.next()) {
                sql = "DELETE FROM rota WHERE numero_Rota = ?";
                connrota.pstm = connrota.conn.prepareStatement(sql);

                connrota.pstm.setInt(1, rota.getNumrota());
                connrota.pstm.execute();
                //   JOptionPane.showMessageDialog(null, "Rota Removido Com Sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Rota não existe !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Remover Rota");
            e.printStackTrace();
        }
        return false;
    }

    public modelRota getrota(int codigo) {

        try {

            connrota.conn = connrota.getConection();
            //  JOptionPane.showMessageDialog(null, ""+ codigo);

            String sql = ("SELECT * FROM rota WHERE numero_Rota= ?;");
            connrota.pstm = connrota.conn.prepareStatement(sql);
            connrota.pstm.setInt(1, codigo);
            // recebendo os resultados do select  e executando a tarefa 
            ResultSet rs = connrota.pstm.executeQuery();
            Model.modelRota f = new modelRota();
            if (rs.next()) {

                f.setNumrota((rs.getInt(1)));
                f.setQuantdias(rs.getInt(2));
                f.setValorRota(rs.getFloat(3));
                f.setIdCidadeOrigem(rs.getInt(4));
                f.setIdCidadeDestino(rs.getInt(5));
                f.setDescricaoRota((rs.getString(6)));

                // verificar bug da mensagem quando nao existe essa mensagem logo abaixo  da erro 
                //com essa mensagem nao 
                //JOptionPane.showMessageDialog(null, "Registros Retornados Com Sucesso");
                return f;
            }
            return f;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar Rota!" + e.getMessage());
        }
        return null;
    }

}
