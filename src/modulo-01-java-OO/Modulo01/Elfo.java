/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia = 0;
    private Status status;

    public Elfo(String nome) {
        this(nome, 42);
    }

    public Elfo(String nome, int flechas){
        this.nome = nome;
        this.flechas = flechas;
        this.status = Status.VIVO;
    }

    public void atirarFlechas(Dwarf alvo){
        flechas--;
        alvo.receberFlechada();
        experiencia++;
    }

    public String toString(){
        boolean flechaNoSingular = this.flechas != 1;
        boolean nivelNoSingular = this.experiencia != 1;
        /*
        if(this.flechas != 1){
            textoFlechas += "s";
        }
        if(this.experiencia != 1){
         textoNiveis = "níveis";   
        }
        */
        
        String textoFormatado = String.format("%s possui %d %s e %d %s de experiencia", 
        this.nome,
        this.flechas,
        flechaNoSingular ? "flechas" : "flecha",
        this.experiencia,
        nivelNoSingular ? "níveis" : "nível"
        );
        
        return textoFormatado;//this.nome + " possui " + this.flechas + " " + textoFlechas + " e " + this.experiencia + " " +textoNiveis + " de experiencia";
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
    
    public Status getStatus(){
        return this.status;
    }
}