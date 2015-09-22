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
    
    public void serAtacado(Object obj){
    }
}
