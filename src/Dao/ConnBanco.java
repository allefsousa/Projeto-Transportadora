package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
public class ConnBanco {

    private String url = "jdbc:mysql://localhost:3306/transportadora";
    private String usuario = "root";
    private String senha = "";
    public ResultSet rs;//Armazena o resultado de uma pesquisa passada para o Statement
    public PreparedStatement pstm;
    public Statement stm;//Prepara e realiza pesquisas no banco de dados
    public Connection conn;//Realiza a conexão com a base de dados.

    /**
     * Realiza a conexão com o banco de dados.
     *
     * @return conn
     */
    public Connection getConection() {
        try {
            conn = DriverManager.getConnection(url, usuario, senha);//Realiza a conexão com o banco
            //JOptionPane.showMessageDialog(null, "Conexão com o banco realizada com sucesso !");//Exibe caixa de mensagem
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão...");//Exibe caixa de mensagem
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    public void desconecta() {
        try {
            conn.close();
           // JOptionPane.showMessageDialog(null, "Desconectado com sucesso !");//Exibe caixa de mensagem
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "Erro ao desconectar...");//Exibe caixa de mensagem
            e.printStackTrace();
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro De Conecxão ExecutaSQL  \n ERRO:" + ex.getMessage());
        }
    }

    public ResultSet executaSQLRetorno(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro De Conecxão ExecutaSQL  \n ERRO:" + ex.getMessage());
        }
        return rs;
    }

}
