
package Model;

/**
 *
 * @author Allef
 */
public class Pessoa {
    private String Nome;
    // Campo Para adicionar mascara
    private String Cpf;
    // Campo Para adicionar mascara
    private String rg;

    public Pessoa(String Nome, String Cpf, String rg) {
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Nome=" + Nome + ", Cpf=" + Cpf + ", rg=" + rg + '}';
    }

    public Pessoa() {
    }

    
    

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
}
