/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia = 0;
    
    public Elfo(String nome) {
        this(nome, 42);
    }
    public Elfo(String nome, int flechas){
        this.nome = nome;
        this.flechas = flechas;
    }
    public void atirarFlechas(Dwarf alvo){
        flechas--;
            alvo.receberFlechada();
            experiencia++;
    }
    public String toString(){
        return (this.nome + " possui " + this.flechas + " e " + 
        this.experiencia + " niveis de experiência.");
    }
    public String getNome(){
        return this.nome;
    }
    public int getFlechas(){
        return this.flechas;
    }
    public int getExperiencia(){
        return this.experiencia;
    }
}