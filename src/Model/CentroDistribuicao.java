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
    private String razaosocial;
    private String nomeFantasia;
    private String emailTransp;
    private String ruaTransp;
    private String numeroTransp;
    private String bairroTransp;
    private int cidade;
    private int cepTransp;
    private String fone;

    public CentroDistribuicao(String cnpj, String razaosocial, String nomeFantasia, String emailTransp, String ruaTransp, String numeroTransp, String bairroTransp, int cidade, int cepTransp, String fone) {
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
        this.nomeFantasia = nomeFantasia;
        this.emailTransp = emailTransp;
        this.ruaTransp = ruaTransp;
        this.numeroTransp = numeroTransp;
        this.bairroTransp = bairroTransp;
        this.cidade = cidade;
        this.cepTransp = cepTransp;
        this.fone = fone;
    }

    public CentroDistribuicao() {
    }

    @Override
    public String toString() {
        return "CentroDistribuicao{" + "cnpj=" + cnpj + ", razaosocial=" + razaosocial + ", nomeFantasia=" + nomeFantasia + ", emailTransp=" + emailTransp + ", ruaTransp=" + ruaTransp + ", numeroTransp=" + numeroTransp + ", bairroTransp=" + bairroTransp + ", cidade=" + cidade + ", cepTransp=" + cepTransp + ", fone=" + fone + '}';
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEmailTransp() {
        return emailTransp;
    }

    public void setEmailTransp(String emailTransp) {
        this.emailTransp = emailTransp;
    }

    public String getRuaTransp() {
        return ruaTransp;
    }

    public void setRuaTransp(String ruaTransp) {
        this.ruaTransp = ruaTransp;
    }

    public String getNumeroTransp() {
        return numeroTransp;
    }

    public void setNumeroTransp(String numeroTransp) {
        this.numeroTransp = numeroTransp;
    }

    public String getBairroTransp() {
        return bairroTransp;
    }

    public void setBairroTransp(String bairroTransp) {
        this.bairroTransp = bairroTransp;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getCepTransp() {
        return cepTransp;
    }

    public void setCepTransp(int cepTransp) {
        this.cepTransp = cepTransp;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

   

    
}
