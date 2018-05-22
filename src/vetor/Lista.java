
package vetor;

import java.security.spec.InvalidParameterSpecException;


public interface Lista<TipoGenerico> {
    
    public void adicionar(TipoGenerico elemento);
    public void adicionarTodos(TipoGenerico... elementos);
    public void adicionar(TipoGenerico elemento, int indice) throws InvalidParameterSpecException;
    public void adicionarNoInicio(TipoGenerico elemento);
    public void adicionarNoFim(TipoGenerico elemento);
    
    public TipoGenerico obter(int indice) throws InvalidParameterSpecException;
    
    public int contem(TipoGenerico valor);
    
    public TipoGenerico remover(int indice) throws InvalidParameterSpecException;
    public TipoGenerico removerNoFim();
    public TipoGenerico removerNoInicio();
    public boolean remover(TipoGenerico elemento);
    
    public void limpar();
    
    public int tamanho();
    
    public int capacidade();
    
    
    
    
    
    
    
    
    
}
