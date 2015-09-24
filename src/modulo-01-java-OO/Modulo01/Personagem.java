public abstract class Personagem{
    protected String nome;
    protected double vida;
    protected int experiencia;
    protected Status status;
    protected final Inventario inventario;

    public Personagem(){
        inventario = new Inventario();
    }

    public Inventario getInventario(){
        return this.inventario;
    }

    public double getVida(){
        return this.vida;
    }
    
    public String getNome(){
        return this.nome;
    }

    public Status getStatus(){
        return this.status; 
    }

    public int getExperiencia(){
        return this.experiencia;
    }  

    public void adicionarItem(Item item){
        inventario.getItens().add(item);
    }

    public void perderItem(Item item){
        inventario.getItens().remove(item);
    }
    
    public abstract void tentarSorte();

    public void receberDano(int dano){
        this.vida -= dano;
        if(vida<=10){
            vida=0;
            this.status = Status.MORTO;
        }
    }

    public void atacar(Object obj){
        if(obj instanceof Dwarf){
            Dwarf dwarf = (Dwarf)obj;
            dwarf.receberAtaque(this);
        }else if(obj instanceof Elfo){
            Elfo elfo = (Elfo)obj;
            elfo.receberAtaque(this);
        }else if(obj instanceof Orc){
            Orc orc = (Orc)obj;
            orc.receberAtaque();
        }
    }

    public Item getItem(String descricao){
        return this.inventario.getItemPelaDescricao(descricao);
    }

    public boolean existeItem(String nome){
        return this.inventario.existeItemComDescricao(nome);
    }

    public void receberAtaqueDoOrc(Orc orc){
        int dano = orc.getDanoDeAtaque();
        this.vida -= dano;
    }
    
    public int hashCode(){
        return this.nome.hashCode() + this.status.toString().hashCode() + new Integer(this.experiencia).hashCode();
     }
}
