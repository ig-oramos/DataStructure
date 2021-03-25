package grafos;

/**
 *
 * @author Igor G. O. Ramos
 */
public class Grafo {
    private ListaLigada[] tabela; // array de arestas
    
    /**
     * Construtor da classe, define o tamanho da tabela
     * @param qtdeVertices
     */
    public Grafo(int qtdeVertices) {
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
        if (verificarVertices(v1, v2)) {
        	v1 = fEspalha(v1);
        	v2 = fEspalha(v2);

            if (tabela[v1] == null)
                tabela[v1] = new ListaLigada();
            
            tabela[v1].adicionaFinal(v2);
            
            if (tabela[v2] == null)
                tabela[v2] = new ListaLigada();

            tabela[v2].adicionaFinal(v1);
        } else
            System.out.println("Vértice(s) de adição inválido(s).");
    }

    /**
     * Verifica se os vértices informados são válidos 
     * @param v1
     * @param v2
     * @return boolean
     */
    private boolean verificarVertices(int v1, int v2) {
        return (v1 > 0 && v1 <= tabela.length && v2 > 0 &&
            v2 <= tabela.length && v1 != v2);
    }
    
    /**
     * Percorre e define os pais dos vértices do grafo
     * @param origem
     * @param destino
     * @return int[] pai que indica os pais dos vértices,
     * fundamentais para determinar se há um menor caminho
     */
    public int[] definirRota(int origem, int destino) {
    	int pai[] = new int[tabela.length];
    	// Verifica se a origem e o destino são válidos
        if (verificarVertices(origem, destino)) {
        	// Fila de vértices a serem percorridos
        	ListaLigada fila = new ListaLigada();
        	// Utiliza a função de espalhamento para tornar
        	// os valores válidos para pesquisa e definição
        	origem = fEspalha(origem);
        	destino = fEspalha(destino);
        	// Array de vértices percorridos
            boolean flg[] = new boolean[tabela.length];
            int p = origem;
            
            iniciarPai(pai);
                        
            flg[p] = true; // origem percorrida
            fila.adicionaFinal(p); // primeiro índice a ser percorrido
            
            No aux = fila.getInicio();
            for (ListaLigada i = tabela[origem]; aux != null; aux = aux.prox) {
            	for (No j = i.getInicio(); j != null; j = j.prox) {
            		if (!flg[j.dado]) {
            			flg[j.dado] = true;
            			pai[j.dado] = p;
            			fila.adicionaFinal(j.dado);
            		}
            	}
            	
           		i = tabela[aux.dado];
           		p = aux.dado;
            }
        } else
            System.out.println("Vértice(s) inválido(s).");
        
        return pai;
    }
    
    /**
     * Inicializa o array de pais com -1 (índice inválido)
     * @param pai
     */
    public void iniciarPai(int[] pai) {
    	for (int i = 0; i < tabela.length; ++i)
    		pai[i] = -1;
    }
    
    public int[] definirPai(int origem, int destino) {
    	if (verificarVertices(origem, destino)) {
    		boolean flg[] = new boolean[tabela.length];
    		int pai[] = new int[tabela.length];
    		iniciarPai(pai);
    		
    		buscaEmLargura(fEspalha(origem), pai, flg);
    		
    		return pai;
    	} else {
    		System.out.println("Vértice(s) inválido(s).");
    		return null;
    	}
    }
    
    public void buscaEmLargura(int origem, int pai[], boolean flg[]) {
		No j;
		int y;
		flg[origem] = true;
		for (j = tabela[origem].getInicio(); j != null; j = j.prox) {
			y = j.dado;
			if (flg[y] == false) {
				pai[y] = origem;
				buscaEmLargura(y, pai, flg);
			}
		}
    }
    
    /**
     * Inicializa os vetores flg e pai e faz a chamada do
     * método responsável pela definição dos pais
     * @param origem
     * @param destino
     * @return int[] pais usados para determinar
     * se existe um caminho e se ele é o menor
     */
    public int[] definirPai2(int origem, int destino) {
    	if (verificarVertices(origem, destino)) {
    		boolean flg[] = new boolean[tabela.length];
    		int pai[] = new int[tabela.length];
    		iniciarPai(pai);
    		
    		bfs(fEspalha(origem), pai, flg);
    		
    		return pai;
    	} else {
    		System.out.println("Vértice(s) inválido(s).");
    		return null;
    	}
    }
    
    /**
     * Usa uma abordagem recursiva para determinar o pai de
     * cada vértice da tabela (do grafo)
     * @param origem
     * @param pai
     * @param flg
     */
    public void bfs(int origem, int pai[], boolean flg[]) {
		No j;
		int y;
		ListaLigada fila = new ListaLigada();
		flg[origem] = true;
		for (j = tabela[origem].getInicio(); j != null; j = j.prox) {
			y = j.dado;
			if (flg[y] == false) {
				pai[y] = origem;
				flg[y] = true;
				fila.adicionaFinal(y);
			}
		}
		
		for (j = fila.getInicio(); j != null; j = j.prox) {
			bfs(j.dado, pai, flg);
		}
    }
    
    public int[] bfs(int start) {
	    int q[] = new int[tabela.length], f, r; /* fila de vertices a visitar */
	    int v; /* current vertex */
	    int y; /* successor vertex */
	    
	    int pai[] = new int[tabela.length];
	    boolean flg[] = new boolean[tabela.length];
        
        for (int i = 0; i < flg.length; ++i)
            pai[i] = -1;
        
	    No p;
	    f = r = 0;
	    /* init_queue(&q) */
	    q[f++] = start; /* enqueue(&q,start) */
	    flg[start] = true;
	    
	    while( f != r ) {
		    v = q[r++]; /* dequeue( &q ); */
		    for( p = tabela[v].getInicio(); p != null; p = p.prox ) {
			    y = p.dado;
			    
			    if(!flg[y]) {
				    q[f++] = y; /* enqueue( &q, y ); */
				    flg[y] = true;
				    pai[y] = v;
			    }
		    }
	    }
	    
	    return pai;
    }
    
    /**
     * Retorna uma String formatada com todas as ligações de cada vértice
     * @return String 
     */
    @Override
    public String toString() {
        String msg = "";
        for (int i = 0; i < tabela.length; ++i)
            msg += String.format("[%d] -> %s\n", i + 1,
            	tabela[i] != null?tabela[i]:"null");

        return msg;
    }
}
