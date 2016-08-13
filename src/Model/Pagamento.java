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
public class Pagamento {
    private Integer NumTransacao;
    private Double valor;
    private Date dataVenc;
    private String TipoPagamento;

    public Pagamento() {
    }

    public Pagamento(Integer NumTransacao, Double valor, Date dataVenc, String TipoPagamento) {
        this.NumTransacao = NumTransacao;
        this.valor = valor;
        this.dataVenc = dataVenc;
        this.TipoPagamento = TipoPagamento;
    }

    public Integer getNumTransacao() {
        return NumTransacao;
    }

    public void setNumTransacao(Integer NumTransacao) {
        this.NumTransacao = NumTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(Date dataVenc) {
        this.dataVenc = dataVenc;
    }

    public String getTipoPagamento() {
        return TipoPagamento;
    }

    public void setTipoPagamento(String TipoPagamento) {
        this.TipoPagamento = TipoPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "NumTransacao=" + NumTransacao + ", valor=" + valor + 
                ", dataVenc=" + dataVenc + ", TipoPagamento=" + TipoPagamento + '}';
    }
}
