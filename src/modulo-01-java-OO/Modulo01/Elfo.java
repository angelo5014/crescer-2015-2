import java.util.Random;

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
        Random gerador = new Random();
        boolean acertou = gerador.nextBoolean();
        return acertou;
    }
    
    public void atirarFlechas(){
        flechas--;
        if(acertar())
			experiencia++;
    }
    
    public void atirarFlechaRefactory(){
        flechas--;
        if(acertar())
            experiencia++;
    }
}