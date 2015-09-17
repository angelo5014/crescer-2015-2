public class Dwarf{
    private int vida = 110;
    private Status status = Status.VIVO;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;

    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void receberFlechada(){
        this.vida -= 10;
        if(vida<=0){
            vida = 0;
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