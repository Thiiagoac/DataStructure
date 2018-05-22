/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

import java.util.Iterator;

/**
 *
 * @author 1161117790
 */
public class Pilha<Tipo> implements IPilha<Tipo> {

    private No<Tipo> base, topo;
    private int tamanho;

    @Override
    public void empilhar(Tipo elemento) {
        No<Tipo> novoNo = new No<>(elemento);
        if (this.base == null) {
            base = topo = novoNo;
            this.tamanho++;
        } else {
            novoNo.setAnterior(topo);
            topo.setProximo(novoNo);
            topo = novoNo;
            this.tamanho++;
        }
    }

    @Override
    public Tipo desempilhar() {
        if (this.base == null) {
            No<Tipo> no = topo;
            this.base = this.topo = null;
            this.tamanho--;
            return (Tipo) no;
        } else {
            No<Tipo> no = topo;
            topo = topo.getAnterior();
            topo.setProximo(null);
            tamanho--;
            return (Tipo) no;
        }
    }

    @Override
    public Tipo topo() {
        return this.topo();
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean contem(Tipo elemento) {
        No<Tipo> no = this.base;
        for (int i = 0; i < this.tamanho; i++) {
            if(elemento == no.getValor()){
                return true;
            }
            no = no.getProximo();
        }
        return false;
    }

    @Override
    public void limpar() {
        this.topo = this.base = null;
    }

    @Override
    public boolean vazia() {
        if (this.base == null) {
            return true;
        } else {
            return false;
        }

    }

    public void toStringPersonal() {
        No<Tipo> no = this.base;
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(no.getValor());
            no = no.getProximo();
        }
    }

    @Override
    public Iterator<Tipo> iterator() {
        //USE O FOR TRADICIONAL PASSAR BEM CARO PROGAMADOR. Thanos > ALL
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
