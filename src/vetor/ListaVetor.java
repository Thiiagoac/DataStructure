package vetor;

import java.security.spec.InvalidParameterSpecException;
import java.util.Iterator;

public class ListaVetor<Tipo> implements Iterable, Lista<Tipo> {
   

    private int tamanho;
    private int capacidade;
    private Tipo[] vetor;

    public ListaVetor() {

    }

    public ListaVetor(int tamanhoInicial) {
        capacidade = tamanhoInicial;
        tamanho = 0;

        vetor = (Tipo[]) new Object[tamanhoInicial];
    }

    public boolean TesteTamanho(Tipo[] vetor) {
        if (tamanho >= capacidade) {
            return true;
        } else {
            return false;
        }
    }

    public void DobrarVetor(Tipo[] vetor) {
        Tipo[] novoVetor = (Tipo[]) new Object[capacidade * 2];
        if (TesteTamanho(this.vetor) == true) {
            for (int i = 0; i < tamanho; i++) {
                novoVetor[i] = vetor[i];
            }
        }
        vetor = novoVetor;
        this.vetor = novoVetor;
        capacidade = novoVetor.length;
    }

    @Override
    public void adicionar(Tipo elemento) {
        if (TesteTamanho(this.vetor)) {
            DobrarVetor(this.vetor);
        }
        this.vetor[tamanho] = elemento;
        this.tamanho++;
    }

    @Override
    public void adicionarTodos(Tipo... elementos) {
        if (TesteTamanho(this.vetor)) {
            DobrarVetor(this.vetor);
        }
        for (Tipo elemento : elementos) {
            this.vetor = (Tipo[]) elemento;
        }

    }

    @Override
    public void adicionar(Tipo elemento, int indice) throws InvalidParameterSpecException {
        if (TesteTamanho(this.vetor)) {
            DobrarVetor(this.vetor);
        }
        //teste fim
        if (indice == tamanho) {
            this.adicionarNoFim(elemento);
            //teste inicio
        } else if (indice == 0) {
            this.adicionarNoInicio(elemento);
            //teste meio
        } else {
            for (int i = 0; i < this.tamanho; i++) {
                if (i == indice) {
                    for (int z = this.tamanho - 1; z < i; i--) {
                        this.vetor[z + 1] = this.vetor[z];
                        this.tamanho++;
                    }
                }
            }
        }
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {
        if (TesteTamanho(this.vetor)) {
            DobrarVetor(this.vetor);
        }
        //jogando vetor pro lado
        for (int i = this.tamanho - 1; i < 0; i--) {
            this.vetor[i + 1] = this.vetor[i];
        }
        this.vetor[0] = elemento;
        this.tamanho++;

    }

    @Override
    public void adicionarNoFim(Tipo elemento) {
        if (TesteTamanho(this.vetor)) {
            DobrarVetor(this.vetor);
        }
        this.vetor[tamanho] = elemento;
        this.tamanho++;
    }

    @Override
    public Tipo obter(int indice) throws InvalidParameterSpecException {
        Tipo z;
        if (indice == 0) {
            z = this.vetor[0];
            return z;
        } else if (indice == tamanho) {
            z = this.vetor[tamanho - 1];
            return z;
        } else {
            try {
                z = this.vetor[indice];
                return z;
            } catch (Exception e) {
                System.out.println("Indice Inexistente");
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int contem(Tipo valor) {
        for (int i = 0; i < this.tamanho; i++) {
            if (valor == this.vetor[i]) {
                return i;
            }
        }
       return 0;
    }

    @Override
    public Tipo remover(int indice) throws InvalidParameterSpecException {
        if (indice == tamanho) {
            Tipo z = vetor[tamanho];
            vetor[tamanho] = null;
            tamanho--;
            return z;
        } else if (indice == 0) {
            //teste inicio
            Tipo w = vetor[0];
            vetor[0] = null;
            //jogando vetor pro lado
            for (int i = 1; i < this.tamanho - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            tamanho--;
            return w;
        } else {
            //teste meio
            for (int i = 0; i < this.tamanho; i++) {
                if (indice == i) {
                    Tipo a = vetor[i];
                    vetor[i] = null;
                    //jogando vetor pro lado
                    for (int z = i; z < this.tamanho - 1; z++) {
                        vetor[z] = vetor[z + 1];

                    }
                    tamanho--;
                    return a;
                }
            }
            return null;
        }
    }

    @Override
    public boolean remover(Tipo elemento
    ) {
        //teste ultimo
        if (elemento == vetor[tamanho - 1]) {
            vetor[tamanho - 1] = null;
            tamanho--;
            return true;
        } else if (elemento == vetor[0]) {
            //teste inicio
            vetor[0] = null;
            for (int i = 1; i < this.tamanho - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            tamanho--;
            return true;
        } else {
            //teste meio
            for (int i = 0; i < this.tamanho; i++) {
                if (vetor[i] == elemento) {
                    vetor[i] = null;
                    for (int z = i; z < this.tamanho - 1; z++) {
                        vetor[z] = vetor[z + 1];

                    }
                    tamanho--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Tipo removerNoFim() {
        Tipo removido = vetor[tamanho - 1];
        vetor[tamanho - 1] = null;
        tamanho--;
        return removido;
    }

    @Override
    public Tipo removerNoInicio() {
        Tipo removido = vetor[0];
        vetor[0] = null;
        for (int i = 1; i < this.tamanho - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        tamanho--;
        return removido;
    }

    @Override
    public void limpar() {
        vetor = (Tipo[]) new Object[10];
        tamanho = 0;
        capacidade = 10;

    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public int capacidade() {
        return capacidade;
    }

    public void toStringPersonal() {
        for (int i = 0; i < this.tamanho(); i++) {
            System.out.println(this.vetor[i]);
        }
    }

    @Override
    public Iterator iterator() {
        return new IteradorVetor();
    }

    private class IteradorVetor<Tipo> implements Iterator<Tipo> {

        private int PosicaoAtual = 0;

        @Override
        public boolean hasNext() {
            if (PosicaoAtual > tamanho) {
                return true;
            }
            return false;
        }

        @Override
        public Tipo next() {
            return (Tipo) vetor[tamanho++];
        }

    }

}
