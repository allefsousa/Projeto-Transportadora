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
import java.sql.ResultSet;
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

    /**
     * Metódo insere veículo no banco de dados
     *
     * @param Veiculo veiculo
     * @return
     */
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

    /**
     * Metodo remove veículo do banco de dados
     *
     * @param Veiculo veiculo
     * @return
     */
    public boolean deletarVeiculo(Veiculo veiculo) {
        try {
            ConnVeic.conn = ConnVeic.getConection();
            String sql = "SELECT id_Veiculo FROM veiculo WHERE id_Veiculo = ?";
            ConnVeic.pstm = ConnVeic.conn.prepareStatement(sql);
            ConnVeic.pstm.setInt(1, veiculo.getId());
            ResultSet rs = ConnVeic.pstm.executeQuery();

            if (rs.next()) {
                sql = "DELETE FROM veiculo WHERE id_Veiculo = ?";
                ConnVeic.pstm = ConnVeic.conn.prepareStatement(sql);
                //ConnFunc.pstm.setString(1, (String.valueOf(funcionario.getNumMatricula())));
                ConnVeic.pstm.setInt(1, veiculo.getId());
                ConnVeic.pstm.execute();
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

    public boolean atualizarFunc(Veiculo veiculo) {

        try {
            ConnVeic.conn = ConnVeic.getConection();
            String sql = "UPDATE veiculo set Id_Veiculo = ?, placa = ?, num_Chassi = ?, capacidade = ?, "
                    + "modelo = ?, fk_Id_Centro_Dist = ?, fk_Id_func = ?, fk_Id_Cidade = ?";
            ConnVeic.pstm = ConnVeic.conn.prepareStatement(sql);
            ConnVeic.pstm.setInt(1, veiculo.getId());
            ConnVeic.pstm.setString(2, veiculo.getPlaca());
            ConnVeic.pstm.setString(3, veiculo.getNumChassi());
            ConnVeic.pstm.setInt(4, veiculo.getCapacidade());
            ConnVeic.pstm.setString(5, veiculo.getModelo());
            ConnVeic.pstm.setInt(6, veiculo.getIdCentroDist());
            ConnVeic.pstm.setInt(7, veiculo.getIdFunc());
            ConnVeic.pstm.setInt(8, veiculo.getCidade());

            //executa a query
            ConnVeic.pstm.execute();
            ConnVeic.conn.close();
            JOptionPane.showMessageDialog(null, "Veiculo atualizado com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Veiculo!");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Método localiza veiculo determinado pelo atributo código passado como
     * parâmetro
     *
     * @param codigo
     * @return Veiculo v
     */
    public Veiculo getVeiculo(int codigo) {
        try {

            ConnVeic.conn = ConnVeic.getConection();

            String sql = ("SELECT id_Veiculo, placa, num_Chassi, capacidade, modelo,"
                    + " fk_Id_Centro_Dist, fk_Id_func, fk_Id_Cidade WHERE id_Veiculo= ?;");
            ConnVeic.pstm = ConnVeic.conn.prepareStatement(sql);
            ConnVeic.pstm.setInt(1, codigo);
            // recebendo os resultados do select  e executando a tarefa 
            ResultSet rs = ConnVeic.pstm.executeQuery();
            Veiculo v = new Veiculo();
            if (rs.next()) {

                v.setId(rs.getInt(1));
                v.setPlaca(rs.getString(2));
                v.setNumChassi(rs.getString(3));
                v.setCapacidade(rs.getInt(4));
                v.setModelo(rs.getString(5));
                v.setIdCentroDist(rs.getInt(6));
                v.setIdFunc(rs.getInt(7));
                v.setCidade(rs.getInt(8));
                // verificar bug da mensagem quando nao existe essa mensagem logo abaixo  da erro 
                //com essa mensagem nao 
                JOptionPane.showMessageDialog(null, "");

            }
            return v;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar veiculo!" + e.getMessage());
        }
        return null;
    }
}
