/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplaEncadeada;

import ListaDuplaEncadeada.IListaDuplaEncadeada;
import java.security.spec.InvalidParameterSpecException;
import java.util.Iterator;

/**
 *
 * @author Thiago
 */
public class ListaDuplaEncadeada<Tipo> implements Iterable, IListaDuplaEncadeada<Tipo> {

    private No<Tipo> inicio, fim;
    private int tamanho;

    //MÉTODOS QUE FALTAM IMPLEMENTAR: 
    //<None>
    //
    //Estrutura testada;
    //
    
    public ListaDuplaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionar(Tipo elemento) {
        No<Tipo> NovoNo = new No<>(elemento);
        if (inicio == null) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            this.fim.setProximo(NovoNo);
            NovoNo.setAnterior(fim);
            fim = NovoNo;
            tamanho++;
        }
    }

    @Override
    public void adicionarTodos(Tipo... elementos) {
        for (Tipo elemento : elementos) {
            this.adicionar(elemento);
        }
    }

    @Override
    public void adicionar(Tipo elemento, int indice) throws InvalidParameterSpecException {
        No<Tipo> NovoNo = new No<>(elemento);
        No<Tipo> no = inicio;
        if (indice == 0) {
            this.adicionarNoInicio(elemento);
        } else if (indice >= this.tamanho) {
            System.out.println("Indice passado de forma inexistente");
        } else if (indice == this.tamanho-1) {
            this.adicionar(elemento);
        } else {
            for (int i = 0; i < indice - 1; i++) {
                no = no.getProximo();
            }
            NovoNo.setProximo(no.getProximo());
            NovoNo.setAnterior(no);
            no.getProximo().setAnterior(NovoNo);
            no.setProximo(NovoNo);
            tamanho++;
        }
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
        No<Tipo> NovoNo = new No<>(elemento);
        if (inicio == null) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            NovoNo.setProximo(inicio);
            inicio.setAnterior(NovoNo);
            inicio = NovoNo;
            tamanho++;
        }

    }

    @Override
    public void adicionarNoFim(Tipo elemento) {
        this.adicionar(elemento);
    }

    @Override
    public Tipo obter(int indice) throws InvalidParameterSpecException {
        No<Tipo> no = inicio;
        No<Tipo> no2 = fim;
        if (indice == 0) {
            return (Tipo) no.getValor();
        } else if (indice == tamanho - 1) {
            return (Tipo) fim.getValor();
        } else if (indice > (tamanho / 2)) {
            for (int i = tamanho - 1; i > indice + 1; i--) {
                no2 = no2.getAnterior();
            }
            return (Tipo) no2.getAnterior().getValor();

        } else {
            for (int i = 0; i < indice - 1; i++) {
                no = no.getProximo();
            }
            return (Tipo) no.getProximo().getValor();
        }
    }

    @Override
    public int contem(Tipo valor) {
        No<Tipo> no = inicio;
        for (int i = 0; i <= tamanho; i++) {
            if (no.getValor() == valor) {
                return i;
            }
            no = no.getProximo();
        }
        return -1;
    }

    @Override
    public Tipo remover(int indice) throws InvalidParameterSpecException {
        No<Tipo> no = inicio;
        No<Tipo> no2 = fim;
        Tipo z = null;
        if (indice == 0) {
            this.removerNoInicio();
        } else if (indice == tamanho - 1) {
            this.removerNoFim();
        } else if (indice > (tamanho / 2)) {
            for (int i = tamanho - 1; i > indice + 1; i--) {
                no2 = no2.getAnterior();
            }
            z = (Tipo) no.getAnterior();
            no2.setAnterior(no2.getAnterior().getAnterior());
            no2.getAnterior().getAnterior().setProximo(no2);
            tamanho--;
            return z;
        } else {
            for (int i = 0; i < indice - 1; i++) {
                no = no.getProximo();
            }
            no.setProximo(no.getProximo().getProximo());
            no.getProximo().setAnterior(no);
            z = (Tipo) no.getProximo().getProximo();
            tamanho--;
            return z;
        }
        return null;
    }

    @Override
    public Tipo removerNoFim() {
        if (inicio == fim) {
            inicio = fim = null;
            tamanho--;
        } else {
            No<Tipo> z = fim;
            fim = fim.getAnterior();
            fim.setProximo(null);
            tamanho--;
            return (Tipo) z;
        }
        return null;
    }

    @Override
    public Tipo removerNoInicio() {
        if (inicio == fim) {
            inicio = fim = null;
            tamanho--;
        } else {
            No<Tipo> no = inicio;
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
            tamanho--;
            return (Tipo) no;
        }
        return null;
    }

   @Override
    public boolean remover(Tipo elemento) {
        No<Tipo> no = inicio;
        if (elemento == inicio.getValor()) {
            this.removerNoInicio();
        } else if (elemento == fim.getValor()) {
            this.removerNoFim();
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (no.getProximo().getValor().equals(elemento)) {
                    no.setProximo(no.getProximo().getProximo());
                    no.getProximo().setAnterior(no);
                    tamanho--;
                    return true;
                }
                no = no.getProximo();
            }
        }
        return false;
    }

    @Override
    public void limpar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public int capacidade() {
        //Lista Simplesmente Encadeada não possui capacidade devido ao fato de não
        //ser criada com uma capacidade predefinidade.
        //Ela é baseada em um nó ligado ao outro fazendo assim que não tenha
        //um limite predefinido.
        //Mas para o método não ficar vazio está retornando o tamanho da lista
         return this.tamanho;
    }

    public void toStringPersonal() {
        No<Tipo> no = inicio;
        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(no.getValor());
            no = no.getProximo();
        }
    }

    @Override
    public Iterator iterator() {
        return new IteradorListaEncadeada();
    }

    private class IteradorListaEncadeada implements Iterator<Tipo> {

        private No<Tipo> proximo;

        public IteradorListaEncadeada() {
            this.proximo = inicio;
        }

        @Override
        public boolean hasNext() {
            return proximo != null;
        }

        @Override
        public Tipo next() {
            Tipo elemento = this.proximo.getValor();
            this.proximo = this.proximo.getProximo();
            return elemento;
        }

    }

}
