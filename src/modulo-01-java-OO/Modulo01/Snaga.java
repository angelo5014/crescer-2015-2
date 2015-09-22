public class Snaga extends Orc{
    public Snaga(){
        super();
        this.vida = 70;
        this.status = Status.VIVO;
        this.inventario.adicionarItem( new Item ("Arco",1));
        this.inventario.adicionarItem(new Item ("Flecha",5));
    }

    public void atacarInimigo(Object obj){
        if(inventario.existeItemComDescricao("Arco")){
            if(inventario.existeItemComDescricao("Flecha")&& 
            inventario.getItemPelaDescricao("Flecha").getQuantidade()>0){
                debitarFlecha();
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
    
    private Item getItem(String descricao){
        return this.inventario.getItemPelaDescricao(descricao);
    }
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            this.inventario.perderItem(flecha);
        }
        else {
            flecha.debitarUmaUnidade();
        }
    }

}
