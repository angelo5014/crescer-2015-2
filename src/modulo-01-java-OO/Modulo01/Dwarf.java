public class Dwarf{
    protected int vida = 110;
    protected Status status;
    protected String nome;
    protected int experiencia;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario = new Inventario();

    public Dwarf (){
        this(null);
    }

    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
        this.experiencia = 0;
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
        }else if (!this.dataNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            return (101 * 33) % 100;
        }else
            return 101;
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333){
            for(Item item : inventario.getItens()){
                item.setQuantidade(item.getQuantidade() + 1000);
            }
    }
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