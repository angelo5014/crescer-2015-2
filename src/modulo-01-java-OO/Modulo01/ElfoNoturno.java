/**
 * Representa objetos do tipo Elfo.
 */
public class ElfoNoturno extends Elfo{

    public ElfoNoturno(String nome){
        super(nome, 42);
    }

    public void atacar(Object obj){
        if(this.status == Status.VIVO){
            super.atacar(obj);
            experiencia += 2;
            this.vida -= (5 * this.vida)/100;
            if(this.vida < 1){
                this.status = Status.MORTO;
            }
        }
    }
}