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
public class CentroDistribuicao {
    private String cnpj;

    public CentroDistribuicao() {
    }

    public CentroDistribuicao(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "CentroDistribuicao{" + "cnpj=" + cnpj + '}';
    }
    
}
