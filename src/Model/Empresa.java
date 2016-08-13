
package Model;

/**
 *
 * @author Allef
 */
public class Empresa {
    private int Cnpj;
    private String NomeFantasia;
    private String RazaoSocial;
    private int TelComercial;
    private int TelComercial1;
    private int Numero;
    private int Cep;
    private String Email;
    private String Endereco;
    //Campo de Seleção
    private int Cidade;
    //Campo de Seleção
    private int Estado;

    public Empresa() {
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
        return TelComercial;
    }

    public void setTelComercial(int TelComercial) {
        this.TelComercial = TelComercial;
    }

    public int getTelComercial1() {
        return TelComercial1;
    }

    public void setTelComercial1(int TelComercial1) {
        this.TelComercial1 = TelComercial1;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int Cep) {
        this.Cep = Cep;
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
        return Cidade;
    }

    public void setCidade(int Cidade) {
        this.Cidade = Cidade;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
}
