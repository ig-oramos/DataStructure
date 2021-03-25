package grafos;

/**
 *
 * @author Igor G. O. Ramos
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo tabela = new Grafo(7);
        
        // Adiciona os elementos no grafo
        tabela.adiciona(1, 2);
        tabela.adiciona(1, 4);
        tabela.adiciona(1, 7);
        tabela.adiciona(2, 4);
        tabela.adiciona(4, 3);
        tabela.adiciona(4, 5);
        tabela.adiciona(5, 3);
        tabela.adiciona(3, 6);
        
        System.out.println("BFS");
        int pai[] = tabela.bfs(1);
        for (int i = 0; i < pai.length; ++i)
        	System.out.printf("[%d] = %d\n", i+1, pai[i]+1);
        
        System.out.println("Menor rota");
        pai = tabela.definirRota(1, 6);
        for (int i = 0; i < pai.length; ++i)
        	System.out.printf("[%d] = %d\n", i+1, pai[i]+1);
        
        System.out.println("Definir pai");
        pai = tabela.definirPai(1, 6);
        for (int i = 0; i < pai.length; ++i)
        	System.out.printf("[%d] = %d\n", i+1, pai[i]+1);
        
        System.out.println("Definir pai - 2");
        pai = tabela.definirPai2(1, 6);
        for (int i = 0; i < pai.length; ++i)
        	System.out.printf("[%d] = %d\n", i+1, pai[i]+1);
        
        System.exit(0);
    }
    
}
