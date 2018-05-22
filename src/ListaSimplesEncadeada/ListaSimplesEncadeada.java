/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimplesEncadeada;

import ListaDuplaEncadeada.No;
import java.security.spec.InvalidParameterSpecException;
import java.util.Iterator;

/**
 *
 * @author Thiago
 */
public class ListaSimplesEncadeada<Tipo> implements Iterable, IListaSimplesEncadeada<Tipo> {

    private No<Tipo> inicio, fim;
    private int tamanho;

    //MÉTODOS QUE FALTAM IMPLEMENTAR: 
    //Adicionar todos;
    //
    //
    //Estrutura testada
    //
    //
    public ListaSimplesEncadeada() {
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
            fim = NovoNo;
            tamanho++;
        }
    }

    @Override
    public void adicionarTodos(Tipo... elementos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionar(Tipo elemento, int indice) throws InvalidParameterSpecException {
        No<Tipo> NovoNo = new No<>(elemento);
        No<Tipo> no = inicio;
        if (indice - 1 == 0) {
            this.adicionarNoInicio(elemento);
        } else if (indice >= this.tamanho) {
            System.out.println("Indice passado de forma inexistente");
        } else if (indice == this.tamanho) {
            this.adicionarNoFim(elemento);
        } else {
            for (int i = 0; i < indice - 2; i++) {
                no = no.getProximo();
            }
            NovoNo.setProximo(no.getProximo());
            no.setProximo(NovoNo);
            tamanho++;
        }
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
        No<Tipo> NovoNo = new No<>(elemento);
        if (inicio == fim) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            NovoNo.setProximo(inicio);
            inicio = NovoNo;
            tamanho++;
        }

    }

    @Override
    public void adicionarNoFim(Tipo elemento) {
        No<Tipo> NovoNo = new No<>(elemento);
        if (inicio == null) {
            inicio = fim = NovoNo;
            tamanho++;
        } else {
            this.fim.setProximo(NovoNo);
            fim = NovoNo;
            tamanho++;
        }
    }

    @Override
    public Tipo obter(int indice) throws InvalidParameterSpecException {
        No<Tipo> no = inicio;
        if (indice - 1 == 0) {
            return (Tipo) no.getValor();
        } else if (indice == tamanho - 1) {
            return (Tipo) fim.getValor();
        } else {
            for (int i = 0; i < indice - 2; i++) {
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
        Tipo z = null;
        if (indice == 0) {
            this.removerNoInicio();
        } else if (indice == tamanho-1) {
            this.removerNoFim();
        } else {
            for (int i = 0; i < indice - 1; i++) {
                no = no.getProximo();
            }
            no.setProximo(no.getProximo().getProximo());
            z = (Tipo) no.getProximo().getProximo();
            tamanho--;
            return z;
        }
        return null;
    }

    @Override
    public Tipo removerNoFim() {
        No<Tipo> no = inicio;
        if (inicio == fim) {
            inicio = fim = null;
            tamanho--;
        } else {
            for (int i = 0; i <= tamanho - 1; i++) {
                if (no.getProximo() == fim) {
                    no.setProximo(null);
                    fim = no;
                    tamanho--;
                    return (Tipo) no.getProximo();
                }
                no = no.getProximo();
            }

        }

        return null;
    }

    @Override
    public Tipo removerNoInicio() {
        No<Tipo> no = inicio;
        if (inicio == fim) {
            inicio = fim = null;
            tamanho--;
        } else {
            inicio = inicio.getProximo();
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
        throw new UnsupportedOperationException("Not supported yet.");
        //Lista Simplesmente Encadeada não possui capacidade devido ao fato de não
        //ser criada com uma capacidade predefinidade.
        //Ela é baseada em um nó ligado ao outro fazendo assim que não tenha
        //um limite predefinido.
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
