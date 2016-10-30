/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Rafael
 */
public class TransportadoraPedido {
    private String CentroDist;
    private int numPedido;
    private Date data;
    private String status;

    public TransportadoraPedido() {
    }

    public TransportadoraPedido(String CentroDist, int numPedido, Date data, String status) {
        this.CentroDist = CentroDist;
        this.numPedido = numPedido;
        this.data = data;
        this.status = status;
    }
    
    public String getCentroDist() {
        return CentroDist;
    }

    public void setCentroDist(String CentroDist) {
        this.CentroDist = CentroDist;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TransportadoraPedido{" + "CentroDist=" + CentroDist + ", numPedido=" + numPedido + ""
                + ", data=" + data + ", status=" + status + '}';
    }
}
