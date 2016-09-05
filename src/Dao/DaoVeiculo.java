/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.CentroDistribuicao;
import Model.Funcionario;
import Model.Veiculo;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class DaoVeiculo {
    
    //Instanciando conexão com banco de dados
    ConnBanco ConnVeic = new ConnBanco();
    //Instanciando funcionario
    Funcionario funcionario = new Funcionario();
    //Instanciando Centro de Distribuição
    CentroDistribuicao centroDist = new CentroDistribuicao();
    
    public boolean insereVeiculo(Veiculo veiculo) {
        ConnVeic.conn = ConnVeic.getConection();
        
        String InsereVeiculo = " INSERT INTO veiculo( placa, num_chassi, capacidade, modelo, fk_Id_Centro_Dist, fk_Id_Func, fk_Id_Cidade)"
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement comando = ConnVeic.conn.prepareStatement(InsereVeiculo);
            // formatar a query 
            comando.setString(1, veiculo.getPlaca());
            comando.setString(2, veiculo.getNumChassi());
            comando.setInt(3, veiculo.getCapacidade());
            comando.setString(4, veiculo.getModelo());
            comando.setInt(5, veiculo.getIdCentroDist());
            comando.setInt(6, veiculo.getIdFunc());
            comando.setInt(7, veiculo.getCidade());

            //executa a query
            comando.execute();
            
            //Fecha a conexao com o BD
            ConnVeic.conn.close();
            
            JOptionPane.showMessageDialog(null, "Veiculo Inserido Com Sucesso !! ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Veiculo !!!" + e);
            e.printStackTrace();
        }

        return false;
    }
}
