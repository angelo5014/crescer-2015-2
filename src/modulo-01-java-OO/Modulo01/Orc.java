abstract class Orc{
    protected int vida;
    protected Status status;
    protected Inventario inventario;
    
    public Orc(){
        inventario = new Inventario();
    }
    
    public void serAtacado(Object obj){
        if(obj instanceof Elfo){
            this.vida -= 8;
        }else if(obj instanceof Dwarf){
            if(inventario.procurarItemPelaDescricaoBoolean("Escudo Uruk-Hai")){
                this.vida -= 5;
            }else{
                this.vida -= 10;
            }
        }
        if(this.vida<=0){
            this.status = Status.MORTO;
            this.vida = 0;
        }
    }
    
    public void atacarInimigo(Object obj){
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
}
