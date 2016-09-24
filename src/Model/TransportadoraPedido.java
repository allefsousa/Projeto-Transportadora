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
    private Date dataEnt;
    private Date dataSaida;
    private String status;

    public TransportadoraPedido() {
    }

    public TransportadoraPedido(String CentroDist, int numPedido, Date dataEnt, Date dataSaida, String status) {
        this.CentroDist = CentroDist;
        this.numPedido = numPedido;
        this.dataEnt = dataEnt;
        this.dataSaida = dataSaida;
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

    public Date getDataEnt() {
        return dataEnt;
    }

    public void setDataEnt(Date dataEnt) {
        this.dataEnt = dataEnt;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
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
                + ", dataEnt=" + dataEnt + ", dataSaida=" + dataSaida + ", status=" + status + '}';
    }
}
