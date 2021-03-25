package grafos;

/**
 *
 * @author Igor G. O. Ramos
 */
public class ListaLigada {
    private No inicio, fim;
    public int tamanho;
    
    public No getInicio() {
        return inicio;
    }
    /**
     * Adiciona um novo nó no início da lista
     * @param e 
     */
    public void adicionaInicio(int e) {
        No novo = new No(e);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        }
        else {
            novo.prox = inicio;
            inicio.ant = novo;
            inicio = novo;
        }
        
        ++tamanho;
    }

    /**
     * Adiciona um novo nó no final da lista
     * @param e 
     */
    public void adicionaFinal(int e) {
        No novo = new No(e);
        
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.prox = novo;
            novo.ant = fim;
            fim = novo;
        }
        
        ++tamanho;
    }
    
    /**
     * Remove um nó do início da lista
     * @return int removido
     */
    public int removeInicio() {
        if (inicio == null)
            return -1;
        
        int r = inicio.dado;
        inicio = inicio.prox;
        inicio.ant = null;
        --tamanho;
        return r;
    }
    
    /**
     * Remove um nó do final da lista
     * @return int removido
     */
    public int removeFinal() {
        if (inicio == null)
            return -1;
        
        int r = fim.dado;
        fim.ant = fim;
        fim.prox = null;
        --tamanho;
        return r;
    }

    /**
     * Retorna uma String com a tabela de espalhamento
     * @return String
     */
    @Override
    public String toString() {
        String msg = "";

        No aux = inicio;
        while (aux.prox != null) {
            msg += (aux.dado + 1) + " -> ";
            aux = aux.prox;
        }

        return msg + (aux.dado + 1);
    }
}
