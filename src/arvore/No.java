/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author 1161137332
 */
public class No<K,V> {
     private No<K,V> esquerda, direita, pai;
     K chave;
     V valor;

    public No(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public No<K, V> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<K, V> esquerda) {
        this.esquerda = esquerda;
    }

    public No<K, V> getDireita() {
        return direita;
    }

    public void setDireita(No<K, V> direita) {
        this.direita = direita;
    }

    public No<K, V> getPai() {
        return pai;
    }

    public void setPai(No<K, V> pai) {
        this.pai = pai;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
     
     
             
}
