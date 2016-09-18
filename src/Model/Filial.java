/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Allef
 */
public class Filial {

    public String fili;
    private static Filial instance;
     private Filial(){
         
     }
  public static Filial getInstance() {
        if (instance == null)
            instance = new Filial();
        return instance;
    }

    public String getFilial() {
        return fili;
    }

    public void setFilial(String fili) {
        this.fili = fili;
    }

    public String retornafilial() {
        String retorno;
        retorno = getFilial();
        return retorno;
    }

}
