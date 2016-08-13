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
public class Pedido {
    private String descricao;
    private Date Pedido;
    private Integer codPedido;

    public Pedido() {
    }

    public Pedido(String descricao, Date Pedido, Integer codPedido) {
        this.descricao = descricao;
        this.Pedido = Pedido;
        this.codPedido = codPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPedido() {
        return Pedido;
    }

    public void setPedido(Date Pedido) {
        this.Pedido = Pedido;
    }

    public Integer getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "descricao=" + descricao + ", Pedido=" + Pedido + ", codPedido=" + codPedido + '}';
    }

}
