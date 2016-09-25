/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */

public class DaoPesquisa_Produto {
      ConnBanco ConnProduto = new ConnBanco();
     public String chaveEstrangeira(String sql, int idChave) {
        try {
            String resultado = null;

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            ConnProduto.conn = ConnProduto.getConection();
            ConnProduto.pstm = ConnProduto.conn.prepareStatement(sql);
            ConnProduto.pstm.setInt(1, idChave);
            ResultSet rs = ConnProduto.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString(1));
            }

            return resultado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        return null;
    }
      public String chaveEstrangeiraString(String sql, String idChave) {
        try {
            String resultado = null;

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            ConnProduto.conn = ConnProduto.getConection();
            ConnProduto.pstm = ConnProduto.conn.prepareStatement(sql);
            ConnProduto.pstm.setString(1, idChave);
            ResultSet rs = ConnProduto.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString(1));
            }

            return resultado;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        return null;
    }
}
