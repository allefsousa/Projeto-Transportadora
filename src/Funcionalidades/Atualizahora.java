/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Dao.ConnBanco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Allef
 */
public class Atualizahora {
    ConnBanco banco = new ConnBanco();

    public void StartData(final JLabel jdata) {
        Thread atualizaData = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Date date = new Date();
                        StringBuffer data = new StringBuffer();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Para Atualizar a DATA so mudar para o formato dd/MM/yyyy
                        jdata.setText(data.toString() + sdf.format(date));
                        Thread.sleep(1000);
                        jdata.revalidate();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        atualizaData.start();
    }

    public void StartHora(final JLabel jhora) {
        Thread atualizaHora = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Date date = new Date();
                        StringBuffer data = new StringBuffer();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // Para Atualizar a DATA so mudar para o formato dd/MM/yyyy
                        jhora.setText(data.toString() + sdf.format(date));
                        Thread.sleep(1000);
                        jhora.revalidate();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        atualizaHora.start();
    }
   
}
