public class Dwarf{
    private int vida = 110;
    private Status status = Status.VIVO;
    private String nome;
    private int experiencia;

    public Dwarf (String nome){
        this.nome = nome;
    }

    public void receberFlechada(){
        this.vida -= 10;
        if(vida<=0){
            status = Status.MORTO;
        }
    }

    public int getVida(){
        return vida;
    }

    public Status getStatus(){
        return this.status; 
    }
}