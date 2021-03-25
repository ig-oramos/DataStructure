package grafos;

/**
 *
 * @author Igor G. O. Ramos
 */
public class TabelaEspalhamento {
    private ListaLigada[] tabela;
    
    /**
     * Construtor da classe, define a quantidade de vértices da tabela
     * @param qtdeVertices 
     */
    public TabelaEspalhamento(int qtdeVertices) {
        tabela = new ListaLigada[qtdeVertices];
    }
    
    /**
     * Função de espalhamento da tabela
     * @param chave
     * @return int
     */
    public int fEspalha(int chave) {
        return chave - 1;
    }
    
    /**
     * Adiciona v1 ao índice v2 e v2 ao índice v1 com a modificação da
     * função de espalhamento
     * @param v1
     * @param v2 
     */
    public void adiciona(int v1, int v2) {
        if (v1 > 0 && v1 <= tabela.length)
            tabela[fEspalha(v1)].adicionaFinal(v2);

        if (v2 > 0 && v2 <= tabela.length)
            tabela[fEspalha(v2)].adicionaFinal(v1);
    }
}
