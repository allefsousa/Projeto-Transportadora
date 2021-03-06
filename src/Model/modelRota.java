/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Allef
 */
public class modelRota {

    private int numrota;
    private int quantdias;
    private int idCidadeOrigem;
    private int idCidadeDestino;
    private float valorRota;
    private String descricaoRota;

    public modelRota() {
    }

    public modelRota(int numrota, int quantdias, int idCidadeOrigem, int idCidadeDestino, float valorRota, String descricaoRota) {
        this.numrota = numrota;
        this.quantdias = quantdias;
        this.idCidadeOrigem = idCidadeOrigem;
        this.idCidadeDestino = idCidadeDestino;
        this.valorRota = valorRota;
        this.descricaoRota = descricaoRota;
    }

    public int getNumrota() {
        return numrota;
    }

    public void setNumrota(int numrota) {
        this.numrota = numrota;
    }

    public int getQuantdias() {
        return quantdias;
    }

    public void setQuantdias(int quantdias) {
        this.quantdias = quantdias;
    }

    public float getValorRota() {
        return valorRota;
    }

    public void setValorRota(float valorRota) {
        this.valorRota = valorRota;
    }

    public String getDescricaoRota() {
        return descricaoRota;
    }

    public void setDescricaoRota(String descricaoRota) {
        this.descricaoRota = descricaoRota;
    }

    public int getIdCidadeOrigem() {
        return idCidadeOrigem;
    }

    public void setIdCidadeOrigem(int idCidadeOrigem) {
        this.idCidadeOrigem = idCidadeOrigem;
    }

    public int getIdCidadeDestino() {
        return idCidadeDestino;
    }

    public void setIdCidadeDestino(int idCidadeDestino) {
        this.idCidadeDestino = idCidadeDestino;
    }

    @Override
    public String toString() {
        return "modelRota{" + "numrota=" + numrota + ", quantdias=" + quantdias + ", idCidadeOrigem=" + idCidadeOrigem + ", idCidadeDestino=" + idCidadeDestino + ", valorRota=" + valorRota + ", descricaoRota=" + descricaoRota + '}';
    }

}
