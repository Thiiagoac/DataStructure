/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

import java.util.Iterator;

/**
 *
 * @author THIAGO
 */
public class Fila<Tipo> implements IFila<Tipo> {

    private No<Tipo> primeiroFila, ultimoFila;
    private int tamanho;

    public Fila() {
        this.primeiroFila = null;
        this.ultimoFila = null;
        this.tamanho = 0;
    }

    @Override
    public void enfileirar(Tipo elemento) {
        No<Tipo> novoNo = new No<>(elemento);
        if (this.tamanho == 0) {
            this.primeiroFila = novoNo;
            this.ultimoFila = novoNo;
            tamanho++;
        } else {
            ultimoFila.setProximo(novoNo);
            novoNo.setAnterior(ultimoFila);
            this.ultimoFila = novoNo;
            tamanho++;
        }

    }

    @Override
    public Tipo desenfileirar() {
        if (this.tamanho == 0) {
            return null;
        } else {
            No<Tipo> no = primeiroFila;
            primeiroFila = primeiroFila.getProximo();
            no = null;
            this.tamanho--;
            return (Tipo) no;
        }
    }

    @Override
    public Tipo primeiro() {
        return this.primeiroFila.getValor();
    }

    @Override
    public Tipo ultimo() {
        return this.ultimoFila.getValor();
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean vazio() {
        if (tamanho > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean contem() {
        return false;
        //o contem que foi passado não possui parametros fiz um contem com parametros
        //para realmente saber o que existe.
    }

    public boolean contem(Tipo valor) {
        No<Tipo> no = primeiroFila;
        for (int i = 0; i <= tamanho; i++) {
            if (no.getValor() == valor) {
                return true;
            }
            no = no.getProximo();
        }
        return false;
    }

    @Override
    public void limpar() {
        primeiroFila = ultimoFila = null;
        tamanho = 0;
    }

    @Override
    public void setTamanhoMaximo(int tamanhoMaximo) {
        System.out.println("tem limite n , ou então implemente vlw <3");

        //a fila vai ser infinita aqui é brasil.
    }

    @Override
    public Iterator<Tipo> iterator() {
        return null;
        //Ta na disney
    }

    public void toStringPersonal() {
        No<Tipo> novoNo = primeiroFila;
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(novoNo.getValor());
            novoNo = novoNo.getProximo();
        }
    }
}
