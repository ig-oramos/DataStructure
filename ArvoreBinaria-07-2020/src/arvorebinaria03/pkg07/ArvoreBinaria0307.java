/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria03.pkg07;

/**
 *
 * @author Igor G. O. Ramos
 */
public class ArvoreBinaria0307 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreAlunos tree = new ArvoreAlunos();

        try {
            tree.adiciona(new Aluno("Igor", "12345"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            tree.adiciona(new Aluno("Allan", "1234"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            tree.adiciona(new Aluno("Joel", "1234"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            tree.adiciona(new Aluno("Raquel", "123"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            tree.adiciona(new Aluno("Keila", "4321"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            tree.adiciona(new Aluno("Ernesto", "12"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            tree.adiciona(new Aluno("Zaine", "4322"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Adds");
        tree.emOrdem(tree.getRaiz());

        System.out.println("Removidos");
        try {
            System.out.println(tree.remover(tree.getRaiz(), "Igor").aluno.getNome());
            System.out.println(tree.remover(tree.getRaiz(), "Zaine").aluno.getNome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("After removes");
        tree.emOrdem(tree.getRaiz());
        
        System.exit(0);
    }
    
}
