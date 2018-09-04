/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

/**
 *
 * @author 1161137332
 */
public interface IArvore<K extends Comparable<K>, V> extends Iterable<V> {

    public V inserir(K chave, V valor);

    public V buscar(K chave);

    public V remover(K chave);

    public void limpar();

    public void listar();

    public int tamanho();

    public boolean contem(V valor);
}
