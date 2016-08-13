/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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

    public boolean verificaLogin(String usuario, String senha) {
        try {
            boolean autentica = false;
            String loginBanco = "";
            String senhaBanco = "";
            connLogin.getConection();
            String sql = "SELECT nomeUsuario,senha FROM funcionario WHERE "
                    + "nomeUsuario = ? AND senha = ? ;";
            connLogin.pstm = connLogin.conn.prepareStatement(sql);
            connLogin.pstm.setString(1, usuario);
            connLogin.pstm.setString(2, senha);
            ResultSet rs = connLogin.pstm.executeQuery();
            if (rs.next()) {
                loginBanco = rs.getString("nomeUsuario");
                senhaBanco = rs.getString("senha");
                autentica = true;
            }
            if(loginBanco.isEmpty() || senhaBanco.isEmpty()){
                JOptionPane.showMessageDialog(null, "Usuario e senha não Conferem !! ");
            }
            return autentica;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar logar!" + ex.toString());
            return false;
        }

    }

}
