/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila;

/**
 *
 * @author 11645
 */
public interface IFila<Tipo> extends Iterable<Tipo>{
    public void enfileirar(Tipo elemento);
    public Tipo desenfileirar();
    public Tipo primeiro();
    public Tipo ultimo();
    public int tamanho();
    public boolean vazio();
    public boolean contem();
    public void limpar();
    public void setTamanhoMaximo(int tamanhoMaximo);
}
