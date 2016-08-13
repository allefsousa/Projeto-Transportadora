//Verificar necessidade dessa classe 

package Model;

/**
 *
 * @author Allef
 */

public class Cliente {
    
    //Campo com mascara 
    private int Cnpj;
    private String NomeFantasia;
    private String RazaoSocial;
    private int telComercial;
    private int telComercial1;
    private int telComercial2;
    private String Email;
    private String Endereco;
    //Campo de Seleção
    private int cidade;
    //Campo de Seleção
    private int estado;
    private String NomeUsuario;
    private String Senha;

    public Cliente() {
   
    }

    public int getCnpj() {
        return Cnpj;
    }

    public void setCnpj(int Cnpj) {
        this.Cnpj = Cnpj;
    }

    public String getNomeFantasia() {
        return NomeFantasia;
    }

    public void setNomeFantasia(String NomeFantasia) {
        this.NomeFantasia = NomeFantasia;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public int getTelComercial() {
        return telComercial;
    }

    public void setTelComercial(int telComercial) {
        this.telComercial = telComercial;
    }

    public int getTelComercial1() {
        return telComercial1;
    }

    public void setTelComercial1(int telComercial1) {
        this.telComercial1 = telComercial1;
    }

    public int getTelComercial2() {
        return telComercial2;
    }

    public void setTelComercial2(int telComercial2) {
        this.telComercial2 = telComercial2;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.NomeUsuario = NomeUsuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
}
