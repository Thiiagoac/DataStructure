/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 *
 * @author 1161137332
 */
public class Arvore<K, V> {

    No<K, V> raiz;

    public Arvore() {
    }

    public No<K, V> add(K chave, V valor, No<K, V> pai) {
        No<K, V> novoNo = new No<>(chave, valor);

        if (raiz == null) {
            raiz = novoNo;
            return novoNo;
        }

        if (pai.getEsquerda() == null) {
            pai.setEsquerda(novoNo);
            return novoNo;
        } else if (pai.getDireita() == null) {
            pai.setDireita(novoNo);
            return novoNo;
        }
       
        return novoNo;
    }

    private No<K, V> remove(K chave) {
        return null;
    }

    public No<K, V> search(No<K, V> pai, K chave) {
        No<K, V> aux;
        if (chave == pai.getEsquerda().chave) {
            return aux = pai.getEsquerda();
        } else if (chave == pai.getDireita().chave) {
            return aux = pai.getDireita();
        }
        return null;
    }

    public void buscaLargura() {
        Queue<No>nos = new ArrayDeque<>();
        nos.add(this.raiz);
        
    }

    @Override
    public String toString() {
        return "Arvore{" + "raiz=" + raiz.getValor() + '}';
    }

}
