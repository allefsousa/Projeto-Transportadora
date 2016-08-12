package Funcionalidades;

import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
public class AbrirNavegador {

    public void AbrirNavegador(int a) {
        try {
            switch (a) {
                case 1:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI(""));
                    break;
                case 2:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://login.live.com"));
                    break;
                case 3:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://web.whatsapp.com"));
                    break;
                case 4:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("http://facebook.com"));
                    break;
                case 5:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.climatempo.com.br/previsao-do-tempo/cidade/443/franca-sp"));
                    break;
                case 6:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.google.com.br/maps"));
                    break;
                case 7:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.caixa.gov.br/Paginas/home-caixa.aspx"));
                    break;
                case 8:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://ib.sicoobnet.com.br/inetbank/login.jsp"));
                    break;
                case 9:
                    java.awt.Desktop.getDesktop().browse(new java.net.URI("https://pagseguro.uol.com.br/hub.jhtml"));
                    break;
               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Impossivel Abrir o Site Desejado.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
