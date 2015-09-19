public class Dwarf{
    private int vida = 110;
    private Status status = Status.VIVO;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario = new Inventario();

    public Dwarf (){
        dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public void receberFlechada(){
        double numeroDaSorte = this.getNumeroSorte();
        if(numeroDaSorte < 0){
            experiencia += 2;
        }else if(numeroDaSorte > 100){
            this.vida -= 10;
        }
        if(vida<=0){
            vida = 0;
            status = Status.MORTO;
        }
    }

    public double getNumeroSorte(){
        if(this.dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90){
            return 101 * -33;
        }else if (!this.dataNascimento.ehBissexto() && this.nome != null && this.nome.equals("Seixas") || this.nome.equals("Meireles")){
            return (101 * 33) % 100;
        }else
            return 101;
    }

    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }

    public void perderItem(Item item){
        inventario.perderItem(item);
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }

    public int getVida(){
        return this.vida;
    }

    public Status getStatus(){
        return this.status; 
    }

    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }

    public int getExperiencia(){
        return this.experiencia;
    }  
}