/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Rafael
 */
public class Veiculo {
    private int id;
    private String placa;
    private int cidade;
    private String estado;
    private String modelo;
    private String numChassi;
    private int capacidade;
    private int idCentroDist;
    private int idFunc;

    public Veiculo() {
    }

    public Veiculo(int id, String placa, int cidade, String estado, String modelo, String numChassi, int capacidade) {
        this.id = id;
        this.placa = placa;
        this.cidade = cidade;
        this.estado = estado;
        this.modelo = modelo;
        this.numChassi = numChassi;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

     public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getIdCentroDist() {
        return idCentroDist;
    }

    public void setIdCentroDist(int idCentroDist) {
        this.idCentroDist = idCentroDist;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    
    
    @Override
    public String toString() {
        return "Veiculo{" + "id =" + id + ", placa =" + placa + ", cidade =" + cidade + 
                 "modelo =" + modelo + ", numChassi =" + numChassi + ", "
                + "capacidade =" + capacidade + ", id = " + idFunc + ", CentroDist = " + idCentroDist +'}';
    } 
}
