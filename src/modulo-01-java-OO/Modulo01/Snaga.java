public class Snaga extends Orc{
    Item arco = new Item ("Arco",1);
    Item flecha = new Item ("Flecha",1);
    public Snaga(){
        super();
        this.vida = 70;
        this.status = Status.VIVO;
        this.inventario.adicionarItem(arco);
        this.inventario.adicionarItem(flecha);
    }

    public void atacarInimigo(Object obj){
        if(inventario.procurarItemPelaDescricaoBoolean("Arco")){
            if(inventario.procurarItemPelaDescricaoBoolean("Flecha")&& 
            inventario.procurarItemPelaDescricao("Flecha").getQuantidade()>0){
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

}
