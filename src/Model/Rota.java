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
public class Rota {
    private Integer codRota;
    private Integer cepOrigem;
    private Integer cepDestino;
    private Integer km;
    private Double valorFrete;

    public Rota() {
    }

    public Rota(Integer codRota, Integer cepOrigem, Integer cepDestino, Integer km) {
        this.codRota = codRota;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.km = km;
    }

    public Integer getCodRota() {
        return codRota;
    }

    public void setCodRota(Integer codRota) {
        this.codRota = codRota;
    }

    public Integer getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(Integer cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public Integer getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(Integer cepDestino) {
        this.cepDestino = cepDestino;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    @Override
    public String toString() {
        return "Rota{" + "codRota=" + codRota + ", cepOrigem=" + cepOrigem + 
                ", cepDestino=" + cepDestino + ", km=" + km + ", valorFrete=" + valorFrete + '}';
    }
    
    
}
