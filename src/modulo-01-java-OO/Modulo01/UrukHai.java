public class UrukHai extends Orc{
    Item espada = new Item ("Espada",1);
    public UrukHai(){
        super();
        this.vida = 150;
        this.status = Status.VIVO;
        this.inventario.adicionarItem(espada);
        this.inventario.adicionarItem(new Item("Escudo Uruk-Hai", 1));
    }

    public void atacarInimigo(Object obj){
        if(inventario.procurarItemPelaDescricaoBoolean("Espada")){
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