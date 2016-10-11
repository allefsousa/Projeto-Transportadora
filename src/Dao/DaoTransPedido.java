/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.TransportadoraPedido;
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
 * @author Rafael
 */
public class DaoTransPedido {
    //Instanciando conexão com banco de dados
    ConnBanco ConnPed = new ConnBanco();
    ConnBanco conEnt = new ConnBanco();
    
    public String chaveEstrangeira(String sql, int idChave) {
        try {
            String resultado = null;

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            conEnt.conn = conEnt.getConection();
            conEnt.pstm = conEnt.conn.prepareStatement(sql);
            conEnt.pstm.setInt(1, idChave);
            ResultSet rs = conEnt.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString(1));
            }

            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        return null;
    }
    
    public boolean insereTranspPedido(TransportadoraPedido transp) {
        ConnPed.conn = ConnPed.getConection();

        String InsereTransPed = " INSERT INTO transportadora_pedido(fk_Centro_Dist, fk_Num_Pedido, dataEntrada, status_Pedido)"
                               +"VALUES(?,?,?,?)";
        try {
            PreparedStatement comando = ConnPed.conn.prepareStatement(InsereTransPed);
            // formatar a query 
            comando.setString(1, transp.getCentroDist());
            comando.setInt(2, transp.getNumPedido());
            
            //Formatando a data para ano mes e dia           
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            
            comando.setString(3, formatter.format(transp.getDataEnt()));
            comando.setString(4, transp.getStatus());

            //executa a query
            comando.execute();

            //Fecha a conexao com o BD
            ConnPed.conn.close();

            //JOptionPane.showMessageDialog(null, "Pedido Inserido Com Sucesso !! ");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Pedido !!!" + e);
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean saidaPedido(TransportadoraPedido transp){
        ConnPed.conn = ConnPed.getConection();

        String saidaTransPed = "Update transportadora_pedido set dataSaida = ? WHERE fk_Centro_Dist = ? AND fk_Num_Pedido = ?";
        try {
            ConnPed.pstm = ConnPed.conn.prepareStatement(saidaTransPed);
            ConnPed.pstm.setString(1, transp.getCentroDist());
            ConnPed.pstm.setInt(2, transp.getNumPedido());
            
            //Formatando a data para ano mes e dia           
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            ConnPed.pstm.setString(3, formatter.format(transp.getDataSaida()));
            
            ConnPed.pstm.execute();
            ConnPed.conn.close();
            JOptionPane.showMessageDialog(null, "Saída de pedido inserida com sucesso !!");
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Pedido !!!" + e);
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean inserirEntregaPedido(TransportadoraPedido transp){
        ConnPed.conn = ConnPed.getConection();

        String saidaTransPed = " INSERT INTO transportadora_pedido(fk_Centro_Dist, fk_Num_Pedido, dataEntrega, status_Pedido)"
                               +"VALUES(?,?,?,?)";
        try {
            PreparedStatement comando = ConnPed.conn.prepareStatement(saidaTransPed);
            // formatar a query 
            comando.setString(1, transp.getCentroDist());
            comando.setInt(2, transp.getNumPedido());
            
            //Formatando a data para ano mes e dia           
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            //comando.setString(3, formatter.format(transp.getDataEnt()));
            //comando.setString(4, formatter.format(transp.getDataSaida()));
            comando.setString(3, formatter.format(transp.getDataEntrega()));
            comando.setString(4, transp.getStatus());

            //executa a query
            comando.execute();

            //Fecha a conexao com o BD
            ConnPed.conn.close();

            //JOptionPane.showMessageDialog(null, "Pedido Inserido Com Sucesso !! ");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Pedido !!!" + e);
            e.printStackTrace();
        }

        return false;
    }
}
