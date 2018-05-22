/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pilha;

/**
 *
 * @author 1161117790
 */
public class No<Tipo> {

    private Tipo valor;
    private No<Tipo> proximo, anterior;

    public No() {
    }

    public No(Tipo valor, No<Tipo> proximo, No<Tipo> anterior) {
        this.valor = valor;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public No(Tipo valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
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

    public No<Tipo> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<Tipo> anterior) {
        this.anterior = anterior;
    }

}