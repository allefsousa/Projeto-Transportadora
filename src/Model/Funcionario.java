package Model;

import java.util.Date;

/**
 *
 * @author Allef
 */
public class Funcionario {

    private int NumMatricula;
    private String Nome;
    private String Rg;
    private String Cpf;
    //Campo De Data
    private Date DataNasc;
   

    private Long TelCelular;
    private String Funcao;
    private int Cep;

    private String Endereco;
  
    private String Estado;
    private String Bairro;
    // campo para data 
    private Date DataRegistro;
    //SubClasse
    private int numero;
    private String complemento;

    private String cnpjTransp;
    private int cidadeFunciCentro;

    public Funcionario(String Nome, String Rg, String Cpf, Date DataNasc, Long TelCelular, String Funcao, int Cep, String Endereco, String Estado, String Bairro, Date DataRegistro, int numero, String complemento, String cnpjTransp, int cidadeFunciCentro) {
        this.Nome = Nome;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.DataNasc = DataNasc;
        this.TelCelular = TelCelular;
        this.Funcao = Funcao;   
        this.Cep = Cep;
        this.Endereco = Endereco;
        this.Estado = Estado;
        this.Bairro = Bairro;
        this.DataRegistro = DataRegistro;
        this.numero = numero;
        this.complemento = complemento;
        this.cnpjTransp = cnpjTransp;
        this.cidadeFunciCentro = cidadeFunciCentro;
    }

 

    public Funcionario() {
    }

    public Funcionario(int NumMatricula) {
        this.NumMatricula = NumMatricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public int getCidadeFunciCentro() {
        return cidadeFunciCentro;
    }

    public void setCidadeFunciCentro(int cidadeFunciCentro) {
        this.cidadeFunciCentro = cidadeFunciCentro;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "NumMatricula=" + NumMatricula + ", DataNasc=" + DataNasc + ", TelCelular=" + TelCelular + ", Funcao=" + Funcao + ", Cep=" + Cep + ", Endereco=" + Endereco + ", Estado=" + Estado + ", Bairro=" + Bairro + ", DataRegistro=" + DataRegistro + ", numero=" + numero + ", complemento=" + complemento + ", nomeUsuario=" +  ", cnpjTransp=" + cnpjTransp + ", cidadeFunciCentro=" + cidadeFunciCentro + '}';
    }

    public int getNumMatricula() {
        return NumMatricula;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public void setNumMatricula(int NumMatricula) {
        this.NumMatricula = NumMatricula;
    }

    public Date getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(Date DataNasc) {
        this.DataNasc = DataNasc;
    }

    public Long getTelCelular() {
        return TelCelular;
    }

    public void setTelCelular(Long TelCelular) {
        this.TelCelular = TelCelular;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int Cep) {
        this.Cep = Cep;
    }
  
    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public Date getDataRegistro() {
        return DataRegistro;
    }

    public void setDataRegistro(Date DataRegistro) {
        this.DataRegistro = DataRegistro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    

    public String getCnpjTransp() {
        return cnpjTransp;
    }

    public void setCnpjTransp(String cnpjTransp) {
        this.cnpjTransp = cnpjTransp;
    }

}
