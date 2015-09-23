public abstract class Personagem{
    protected String nome;
    protected int vida;
    protected int experiencia;
    protected Status status;
    protected Inventario inventario;

    public Personagem(){
        this(null);
    }

    public Personagem(String nome){
        this.nome = nome;
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

    public int getExperiencia(){
        return this.experiencia;
    }  

    public void adicionarItem(Item item){
        inventario.getItens().add(item);
    }

    public void perderItem(Item item){
        inventario.getItens().remove(item);
    }

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
}
