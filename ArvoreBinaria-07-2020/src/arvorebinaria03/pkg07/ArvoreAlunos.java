package arvorebinaria03.pkg07;

/**
 *
 * @author Igor G. O. Ramos
 */

public class ArvoreAlunos {
    private No raiz;

    public void adiciona(Aluno aluno) {
        if (raiz == null)
            raiz = new No(aluno);
        else
            adiciona(aluno, raiz);
    }

    public void adiciona(Aluno aluno, No raiz) {
        if (aluno.getNome().compareTo(raiz.aluno.getNome()) > 0)
            if (raiz.direito == null)
                raiz.direito = new No(aluno);
            else
                adiciona(aluno, raiz.direito);
        else if (aluno.getNome().equalsIgnoreCase(raiz.aluno.getNome()))
            System.out.println("Aluno já existe");
        else if (raiz.esquerdo == null)
            raiz.esquerdo = new No(aluno);
        else
            adiciona(aluno, raiz.esquerdo);
    }

    public No remove(String nome) throws Exception {
        if (raiz == null)
            throw new Exception("Arvore vazia.");
        return new No(new Aluno("Teste", "1234"));
    }

    public No remover(No node, String nome) {
        System.out.println("Percorrendo No com o nome " + node.aluno.getNome());
        if (raiz == null) {
            System.out.println("Arvore vazia");
        }
        if (nome.compareTo(node.aluno.getNome()) < 0)
            node.esquerdo = remover(node.esquerdo, nome);
        else if (nome.compareTo(node.aluno.getNome()) > 0)
            node.direito = remover(node.direito, nome);
        else if (node.esquerdo != null && node.direito != null) {
            System.out.println("Removeu No com o nome " + node.aluno.getNome());
            node.aluno.setNome(encontraMinimo(node.direito).aluno.getNome());
//             node.direito = removeMinimo(node.direito); // Antigo
            removeMinimo(node.direito); // novo
        } else {
            System.out.println("Removeu No com o nome " + node.aluno.getNome());
            node = (node.esquerdo != null) ? node.esquerdo : node.direito;
        }
        return node;
    }

    public No encontraMinimo(No raiz) {
        while (raiz.esquerdo != null) {
            raiz = raiz.esquerdo;
        }

        return raiz;
    }

    public No removeMinimo(No raiz) {
        if (raiz.esquerdo == null)
            return null;

        while (raiz.esquerdo.esquerdo != null) {
            raiz = raiz.esquerdo;
        }

        No r = raiz.esquerdo;
        raiz.esquerdo = null;
        return r;
    }

    public void emOrdem(No raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerdo);
            System.out.printf("Elemento { nome: %s, ra: %s }\n",
                raiz.aluno.getNome(), raiz.aluno.getRa());
            emOrdem(raiz.direito);
        }            
    }

    public No getRaiz() {
        return raiz;
    }
}