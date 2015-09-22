public class UrukHai extends Orc{
    public UrukHai(){
        super();
        this.vida = 150;
        this.status = Status.VIVO;
        this.inventario.adicionarItem(new Item("Espada", 1));
        this.inventario.adicionarItem(new Item("Escudo Uruk-Hai", 1));
    }

    public void atacarInimigo(Object obj){
        if(inventario.existeItemComDescricao("Espada")){
            if(obj instanceof Elfo){
                Elfo elfo = (Elfo)obj;
                elfo.serAtacado(this);
            }else if(obj instanceof Dwarf){
                Dwarf dwarf = (Dwarf)obj;
                dwarf.serAtacado(this);
            }
        }else{
            this.status = Status.FUGINDO;
        }
    }
    
}