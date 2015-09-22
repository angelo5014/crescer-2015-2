public class Dwarf extends Personagem{
    protected DataTerceiraEra dataNascimento;

    public Dwarf (){
        this(null);
    }

    public Dwarf (String nome){
        this(nome, new DataTerceiraEra(1,1,1));
    }

    public Dwarf (String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.vida = 110;
        this.dataNascimento = dataNascimento;
        this.status = Status.VIVO;
        this.experiencia = 0;
        inventario = new Inventario();
    }
    
    public void darMachadada(Object obj){
        if(obj instanceof Elfo){
            Elfo elfo = (Elfo)obj;
            elfo.serAtacado(this);
            experiencia++;
        }else if(obj instanceof UrukHai){
            UrukHai urukHai = (UrukHai)obj;
            urukHai.serAtacado(this);
        }else if(obj instanceof Snaga){
            Snaga snaga = (Snaga)obj;
            snaga.serAtacado(this);
        }
    }

    public void serAtacado(Object obj){
        if(obj instanceof UrukHai){
            this.vida -= 12;
        }else if(obj instanceof Snaga){
            this.vida -= 8;
        }
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