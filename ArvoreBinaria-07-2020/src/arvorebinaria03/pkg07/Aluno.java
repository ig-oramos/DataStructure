package arvorebinaria03.pkg07;

/**
 *
 * @author Igor G. O. Ramos
 */
public class Aluno {
    private String nome, ra;

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
    
    /**
     * Retorna uma String com os dados do aluno
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Aluno { Nome: %s, RA: %s }", nome, ra);
    }
}
