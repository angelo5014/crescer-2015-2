/**
 * Representa objetos do tipo Elfo.
 */
public class ElfoNoturno extends Elfo{

    public ElfoNoturno(String nome){
        this(nome, 42);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }

    public void atacar(Object obj){
        if(this.status == Status.VIVO){
            super.atacar(obj);
            experiencia += 2;
            this.vida -= (5 * this.vida)/100;
            if(this.vida < 1){
                this.status = Status.MORTO;
                this.vida = 0;
            }
        }
    }
}