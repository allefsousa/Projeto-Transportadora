
package Model;


/**
 *
 * @author Allef
 */
public class Usuario extends Funcionario {

   private String Usuario;
   private String Senha;
   private int NivelDeAcesso; // variavel para controlar oque cada funcionario deve utilizar no sistema

    public Usuario(String Usuario, String Senha, int NumMatricula , int NivelDeAcesso) {
        super(NumMatricula);
        this.Usuario = Usuario;
        this.Senha = Senha;
        this.NivelDeAcesso = NivelDeAcesso;
    }

    public int getNivelDeAcesso() {
        return NivelDeAcesso;
    }

    public void setNivelDeAcesso(int NivelDeAcesso) {
        this.NivelDeAcesso = NivelDeAcesso;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }


    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Usuario=" + Usuario + ", Senha=" + Senha + ", NivelDeAcesso=" + NivelDeAcesso + '}';
    }

    public Usuario() {
       
    }

   

    
   
}
