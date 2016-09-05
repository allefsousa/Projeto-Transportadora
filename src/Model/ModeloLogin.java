/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Date;

/**
 *
 * @author Allef
 */
public class ModeloLogin {
    public String CentroOn;
    private String Usuario;
    private String senha;
    private String CentroDis;
    private String cpf;
    private Date nasc; 

    public String getUsuario() {
        return Usuario;
    }

    public String getCentroOn() {
        return CentroOn;
    }

    public void setCentroOn(String CentroOn) {
        this.CentroOn = CentroOn;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCentroDis() {
        return CentroDis;
    }

    public void setCentroDis(String CentroDis) {
        this.CentroDis = CentroDis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNasc() {
        return nasc;
    }

    public void setNasc(Date nasc) {
        this.nasc = nasc;
    }

    public ModeloLogin() {
    }
    
}
