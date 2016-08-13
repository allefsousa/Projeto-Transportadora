package Model;

import java.util.Date;

/**
 *
 * @author Allef
 */
public class Funcionario extends Pessoa {

    private int NumMatricula;
    //Campo De Data
    private Date DataNasc;
    // Campo Para adicionar mascara
    private int TelFixo;
    // Campo Para adicionar mascara
    private int TelCelular;    
    private String Funcao;     
    private int Cep;   
   
    private String Endereco;
    private String Cidade; 
    private String Estado;
    private String rua;
    private String Bairro;
    // campo para data 
    private Date DataRegistro;
    //SubClasse
    private Double Salario;
    private int numero;
    private String complemento;
    private String nomeUsuario;
    private String senha;
    private int cnpjTransp;

    public Funcionario() {
    }

    public Funcionario(int NumMatricula, Date DataNasc, int TelFixo, int TelCelular,
            String Funcao, int Cep, String Cidade, String Estado, String rua, String Bairro,
            Date DataRegistro, Double Salario, int numero, String complemento,
            String Nome, String Cpf, String rg, String nomeUsuario, String senha,
            int cnpjTransp) {
        super(Nome, Cpf, rg);
        this.NumMatricula = NumMatricula;
        this.DataNasc = DataNasc;
        this.TelFixo = TelFixo;
        this.TelCelular = TelCelular;
        this.Funcao = Funcao;
        this.Cep = Cep;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.rua = rua;
        this.Bairro = Bairro;
        this.DataRegistro = DataRegistro;
        this.Salario = Salario;
        this.numero = numero;
        this.complemento = complemento;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.cnpjTransp = cnpjTransp;
    }

    public Funcionario(int NumMatricula) {
        this.NumMatricula = NumMatricula;
    }    

    @Override
    public String toString() {
        return "Funcionario{" + "NumMatricula=" + NumMatricula + ", DataNasc=" 
                + DataNasc + ", TelFixo=" + TelFixo + ", TelCelular=" + TelCelular 
                + ", Funcao=" + Funcao + ", Cep=" + Cep + ", Cidade=" + Cidade 
                + ", Estado=" + Estado + ", rua=" + rua + ", Bairro=" + Bairro 
                + ", DataRegistro=" + DataRegistro + ", Salario=" + Salario 
                + ", numero=" + numero + ", complemento=" + complemento 
                + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha +", cnpjTransp=" + cnpjTransp + '}';
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

    public int getTelFixo() {
        return TelFixo;
    }

    public void setTelFixo(int TelFixo) {
        this.TelFixo = TelFixo;
    }

    public int getTelCelular() {
        return TelCelular;
    }

    public void setTelCelular(int TelCelular) {
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

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
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

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCnpjTransp() {
        return cnpjTransp;
    }

    public void setCnpjTransp(int cnpjTransp) {
        this.cnpjTransp = cnpjTransp;
    }

    

}
