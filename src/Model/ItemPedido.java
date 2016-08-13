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
public class ItemPedido {
    private String descricao;
    private Integer quantidade;
    private Integer numItemPedido;

    public ItemPedido() {
    }

    public ItemPedido(String descricao, Integer quantidade, Integer numItemPedido) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.numItemPedido = numItemPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getNumItemPedido() {
        return numItemPedido;
    }

    public void setNumItemPedido(Integer numItemPedido) {
        this.numItemPedido = numItemPedido;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "descricao=" + descricao + ", quantidade=" + quantidade + 
                ", numItemPedido=" + numItemPedido + '}';
    }
    
    
}
