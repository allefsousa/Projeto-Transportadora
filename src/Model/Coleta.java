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
public class Coleta {

    private Integer codColeta;
    private Date dataColeta;
    private String endereco;
    private Integer numero;
    private Integer cep;
    //Campo de seleção
    private String cidade;
    //Campo de seleção
    private String estado;

    public Coleta() {

    }

    public Coleta(Integer codColeta, Date dataColeta, String endereco, Integer numero, Integer cep, String cidade, String estado) {
        this.codColeta = codColeta;
        this.dataColeta = dataColeta;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getCodColeta() {
        return codColeta;
    }

    public void setCodColeta(Integer codColeta) {
        this.codColeta = codColeta;
    }

    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
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

    @Override
    public String toString() {
        return "Coleta{" + "codColeta=" + codColeta + ", dataColeta=" + dataColeta
                + ", endereco=" + endereco + ", numero=" + numero + ", cep=" + cep
                + ", cidade=" + cidade + ", estado=" + estado + '}';
    }

}
