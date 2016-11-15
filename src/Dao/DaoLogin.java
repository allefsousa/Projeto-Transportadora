/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ModeloLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author allef
 */
public class DaoLogin {

    ConnBanco connLogin = new ConnBanco();

    public boolean verificaLogin(ModeloLogin m) {
        try {
            boolean autentica = false;
            String loginBanco = "";
            String senhaBanco = "";
            String centrod = "";
            connLogin.getConection();
            String sql = "SELECT nome,senha,fk_cnpj_centro_dis FROM login WHERE "
                    + "nome = ? AND senha = ? AND fk_cnpj_centro_dis = ? ;";
            connLogin.pstm = connLogin.conn.prepareStatement(sql);
            connLogin.pstm.setString(1, m.getUsuario());
            connLogin.pstm.setString(2, m.getSenha());
            connLogin.pstm.setString(3, m.getCentroDis());
            ResultSet rs = connLogin.pstm.executeQuery();
            if (rs.next()) {
                loginBanco = rs.getString("nome");
                senhaBanco = rs.getString("senha");
                centrod = rs.getString("fk_cnpj_centro_dis");
                autentica = true;
            }
            if(loginBanco.isEmpty() || senhaBanco.isEmpty()){
                JOptionPane.showMessageDialog(null, "Usuario e senha não Conferem !! ");
                autentica = false;
            }
             connLogin.desconecta();
            return autentica;
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar logar!" + ex.toString());
            return false;
        }

    }

   

}
