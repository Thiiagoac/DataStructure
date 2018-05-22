/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplaEncadeada;

import java.security.spec.InvalidParameterSpecException;

public interface IListaDuplaEncadeada<Tipo> {

    public void adicionar(Tipo elemento);

    public void adicionarTodos(Tipo... elementos);

    public void adicionar(Tipo elemento, int indice) throws InvalidParameterSpecException;

    public void adicionarNoInicio(Tipo elemento);

    public void adicionarNoFim(Tipo elemento);

    public Tipo obter(int indice) throws InvalidParameterSpecException;

    public int contem(Tipo valor);

    public Tipo remover(int indice) throws InvalidParameterSpecException;

    public Tipo removerNoFim();

    public Tipo removerNoInicio();

    public boolean remover(Tipo elemento);

    public void limpar();

    public int tamanho();

    public int capacidade();

}
