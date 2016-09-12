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
    private String idCentroDist;
    private int idFunc;
private int i;
    public Veiculo() {
    }

    /**
     * Construtor utilizado para testar os metodos da classe Inserir Veiculo
     *
     * @param placa
     * @param numChassi
     * @param capacidade
     * @param modelo
     * @param idCentroDist
     * @param idFunc
     * @param cidade
     */
    public Veiculo(String placa, String numChassi, int capacidade, String modelo, String idCentroDist, int idFunc, int cidade) {

        this.placa = placa;
        this.cidade = cidade;
        this.idCentroDist = idCentroDist;
        this.idFunc = idFunc;
        this.modelo = modelo;
        this.numChassi = numChassi;
        this.capacidade = capacidade;
    }
    /**
     * Construtor para Atualizar Veiculo
     * @param placa
     * @param numChassi
     * @param capacidade
     * @param modelo
     * @param idCentroDist
     * @param idFunc
     * @param cidade
     * @param id 
     */
 public Veiculo(String placa, String numChassi, int capacidade, String modelo, String idCentroDist, int idFunc, int cidade,int id) {

        this.placa = placa;
        this.cidade = cidade;
        this.idCentroDist = idCentroDist;
        this.idFunc = idFunc;
        this.modelo = modelo;
        this.numChassi = numChassi;
        this.capacidade = capacidade;
        this.id = id;
    }
    /**
     * Construtor utilizado para testar os metodos da classe Deletar Veiculo
     *
     * @param id
     */
    public Veiculo(int id) {
        this.id = id;
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
     public Veiculo(int id,String placa, String numChassi, int capacidade, String modelo, String idCentroDist, int idFunc) {
        this.id = id;
        this.placa = placa;
        this.idCentroDist = idCentroDist;
        this.idFunc = idFunc;
        this.modelo = modelo;
        this.numChassi = numChassi;
        this.capacidade = capacidade;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
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

    public String getIdCentroDist() {
        return idCentroDist;
    }

    public void setIdCentroDist(String idCentroDist) {
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
        return "Veiculo{" + "id =" + id + ", placa =" + placa + ", cidade =" + cidade
                + "modelo =" + modelo + ", numChassi =" + numChassi + ", "
                + "capacidade =" + capacidade + ", id = " + idFunc + ", CentroDist = " + idCentroDist + '}';
    }
}
