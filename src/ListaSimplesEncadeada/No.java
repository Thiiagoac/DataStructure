/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ListaSimplesEncadeada;

/**
 *
 * @author Thiago
 */
public class No<Tipo> {
   private Tipo valor;
   private No<Tipo> proximo;

    public No() {
    }
    
    public No(Tipo valor, No<Tipo> proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }


    public No(Tipo valor) {
        this.valor = valor;
        this.proximo = null;
    }

    
    
    public Tipo getValor() {
        return valor;
    }

    public void setValor(Tipo valor) {
        this.valor = valor;
    }

    public No<Tipo> getProximo() {
        return proximo;
    }

    public void setProximo(No<Tipo> proximo) {
        this.proximo = proximo;
    }

    
    
   
      
}
