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
     private float valorRota;
    private String descricaoRota;

    public modelRota() {
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

    @Override
    public String toString() {
        return "DaoRota{" + "numrota=" + numrota + ", quantdias=" + quantdias + ", valorRota=" + valorRota + ", descricaoRota=" + descricaoRota + '}';
    }
       
}
