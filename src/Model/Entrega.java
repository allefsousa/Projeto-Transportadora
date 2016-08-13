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
public class Entrega {
    private Date data;
    private Integer numEntrga;
    private String tipoEntrega;
    private String endereco;
    private Integer cep;
    private String bairro;
    private Integer numero;
    //Campo de seleção
    private String cidade;
    //Campo de seleção
    private String Estado;

    public Entrega() {
    }

    public Entrega(Date data, Integer numEntrga, String tipoEntrega, String endereco, Integer cep, String bairro, Integer numero, String cidade, String Estado) {
        this.data = data;
        this.numEntrga = numEntrga;
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.Estado = Estado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getNumEntrga() {
        return numEntrga;
    }

    public void setNumEntrga(Integer numEntrga) {
        this.numEntrga = numEntrga;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Entrega{" + "data=" + data + ", numEntrga=" + numEntrga + ", "
                + "tipoEntrega=" + tipoEntrega + ", endereco=" + endereco + ", "
                + "cep=" + cep + ", bairro=" + bairro + ", numero=" + numero + ", "
                + "cidade=" + cidade + ", Estado=" + Estado + '}';
    }
    
    
}
