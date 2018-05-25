/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaHash;

/**
 *
 * @author 11645
 */
public interface ITabelaHash<K, E> extends Iterable<E>{
    public void inserir(K chave, E valor);
    public E buscar(K chave);
    public E remover(K chave);
    public int tamanho(); //qtdElementos
    public void limpar();
    public boolean contem(E valor);
    public boolean contemChave(K chave);
}
