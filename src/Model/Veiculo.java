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
    private String cidade;
    private String estado;
    private String modelo;
    private String numChassi;
    private int capacidade;
    private String idCentroDist;
    private String idFunc;

    public Veiculo() {
    }

    public Veiculo(int id, String placa, String cidade, String estado, String modelo, String numChassi, int capacidade) {
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
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

    public String getIdCentroDist() {
        return idCentroDist;
    }

    public void setIdCentroDist(String idCentroDist) {
        this.idCentroDist = idCentroDist;
    }

    public String getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(String idFunc) {
        this.idFunc = idFunc;
    }

    
    
    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", cidade=" + cidade + 
                "estado= "+ estado + "modelo=" + modelo + ", numChassi=" + numChassi + ", capacidade=" + capacidade + '}';
    } 
}
