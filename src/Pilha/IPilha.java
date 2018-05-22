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
public interface IPilha<Tipo> extends Iterable<Tipo>{
    public void empilhar(Tipo elemento);
    public Tipo desempilhar();
    public Tipo topo();
    public int tamanho();
    public boolean contem(Tipo elemento);
    public void limpar();
    public boolean vazia();
}
