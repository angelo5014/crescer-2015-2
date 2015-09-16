/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas;
    private int experiencia = 0;
    
    public Elfo(String n) {
        nome = n;
        flechas = 42;
    }
    
    public Elfo(String n, int flech){
        nome = n;
        flechas = flech;
    }
    
    public boolean acertar(){
        boolean acertou = Math.random() * 100 < 50;
        return acertou;
    }
    
    public void atirarFlechas(Dwarve alvo){
        flechas--;
        if(acertar()){
            alvo.vida = alvo.vida - 10;
	        experiencia++;
	   }
    }
    public String getNome(){
        return this.nome;
    }
    /*public void setNome(String nome){
        this.nome = nome;
    }
    */
    public int getFlechas(){
        return this.flechas;
    }
}