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
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here

        Arvore <Integer,String> nomes = new Arvore<>();
        
        No<Integer,String> br = nomes.add(12, "Brasil", null);
        No<Integer,String> sergipe = nomes.add(13, "Sergipe",br );
        No<Integer,String> alagoas = nomes.add(14, "Alagoas", br );
        No<Integer,String> estancia = nomes.add(15, "estancia", sergipe);
        
        System.out.println(nomes.raiz.getDireita().valor);
        System.out.println(nomes.search(sergipe,15).valor);
        System.out.println(nomes.raiz.getDireita().valor);
    }
}
