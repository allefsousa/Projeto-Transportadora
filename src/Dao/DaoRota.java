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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
     
public class DaoRota {
    ConnBanco connrota = new  ConnBanco();
    modelRota modelrota= new Model.modelRota();
     public boolean insereRota(modelRota rota) {
        connrota.conn = connrota.getConection();
        String InsereRota = " INSERT INTO rota(qtd_Dias, valor_Rota, descricao_Rota)"
                + "VALUES(?,?,?)";

        try {
            PreparedStatement comando = connrota.conn.prepareStatement(InsereRota);
            // formatar a query 
            comando.setInt(1, rota.getQuantdias());
            comando.setFloat(2, rota.getValorRota());
            comando.setString(3, rota.getDescricaoRota());
           
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
            String sql = "UPDATE rota set  qtd_Dias = ?, valor_Rota = ?, descricao_Rota = ? where numero_Rota =? ";
            
            connrota.pstm = connrota.conn.prepareStatement(sql);
           
            connrota.pstm.setInt(1, rota.getQuantdias());
            connrota.pstm.setFloat(2, rota.getValorRota());
            connrota.pstm.setString(3, rota.getDescricaoRota());
             connrota.pstm.setInt(4, rota.getNumrota());
            
            
            //executa a query
            connrota.pstm.execute();
            connrota.conn.close();
            JOptionPane.showMessageDialog(null, "Rota atualizada com sucesso !");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Rota!" +e.getMessage());
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

    public Funcionario getFuncionario(int codigo) {

        try {

            connrota.conn = connrota.getConection();
            //  JOptionPane.showMessageDialog(null, ""+ codigo);
            DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
            String sql = ("SELECT id,cpf, nome, rg, dataNasc, cargo, cep, rua, numero, bairro, complemento, estado, dataRegistro, fone, fk_Cnpj_Centro_Dist, Fk_Cidade_Func FROM funcionario WHERE id= ?;");
            connrota.pstm = connrota.conn.prepareStatement(sql);
            connrota.pstm.setInt(1, codigo);
            // recebendo os resultados do select  e executando a tarefa 
            ResultSet rs = connrota.pstm.executeQuery();
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
                f.setTelCelular(rs.getLong(14));

                f.setCnpjTransp(rs.getString(15));
                f.setCidadeFunciCentro(rs.getInt(16));
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
