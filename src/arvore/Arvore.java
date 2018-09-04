/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author 1161137332
 */
public class Arvore<K extends Comparable<K>, V> implements IArvore<K, V> {

    private No<K, V> raiz;
    private int tamanho = 0;

    public Arvore() {
    }
    /*
     public No<K, V> inserir(K chave, V valor, No<K, V> pai) {
     No<K, V> novoNo = new No(chave, valor, pai);
     if (raiz == null) {
     raiz = novoNo;
     } else if (raiz.getEsquerda() == null) {
     raiz.setEsquerda(novoNo);
     novoNo.setPai(raiz);

     } else if (raiz.getDireita() == null) {
     raiz.setDireita(novoNo);
     novoNo.setPai(raiz);
     }
     return novoNo;
     }*/

    public int compareTo(K chave) {
        if (chave.hashCode() < raiz.chave.hashCode()) {
            return -1;
        }
        if (chave.hashCode() > raiz.chave.hashCode()) {
            return 1;
        }
        return 0;
    }

    @Override
    public V inserir(K chave, V valor) {
        No<K, V> novoNo = new No(chave, valor);
        if (this.raiz == null) {
            this.raiz = novoNo;
            this.tamanho++;
        } else {
            No<K, V> pai = (No<K, V>) buscar(chave);
            
            if(valor.hashCode() < pai.valor.hashCode()){
                pai.esquerda = novoNo;
                pai.esquerda.pai = pai;
                return valor;
                
            }else {
                pai.direita = novoNo;
                pai.direita.pai = pai;
                return valor;
            }
        }

        return valor;
    }

    public void buscaEmProfundidade() {
    }

    @Override
    public V buscar(K chave) {
        No<K, V> no = raiz;
        while (no != null) {
            if (compareTo(chave) == -1) {
                no = no.esquerda;
            } else if (compareTo(chave) == 1) {
                no = no.direita;
            } else {
                return no.valor;
            }
        }
        return null;
    }

    @Override
    public V remover(K chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contem(V valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<V> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
