/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelaHash;

import ListaDuplaEncadeada.ListaDuplaEncadeada;
import java.util.Iterator;
import vetor.ListaVetor;

/**
 *
 * @author 1161137332
 */
public class TabelaHash <Chave,Elemento> implements ITabelaHash<Chave, Elemento>{
    private ListaVetor <ListaDuplaEncadeada<HashNo>> tabela;
    private final float limite = 0.75f;
    private int tamanho;
    private final int tamanhoCriacao;
    private int tamanhoRehash;

    public TabelaHash() {
        tabela = new ListaVetor<>(tamanhoRehash = tamanhoCriacao = 16);
    }

    public TabelaHash(int tamanho) {
         tabela = new ListaVetor<>(tamanhoRehash = tamanhoCriacao = tamanho);
    }
    
    private int funcaoHash(Chave k){
        return (int) Math.abs(k.hashCode() % tamanhoCriacao);
    }

    @Override
    public void inserir(Chave chave, Elemento valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Elemento buscar(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Elemento remover(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contem(Elemento valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contemChave(Chave chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Elemento> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
