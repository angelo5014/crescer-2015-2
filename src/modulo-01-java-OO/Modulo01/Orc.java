abstract class Orc extends Personagem{
    public Orc(){
        inventario = new Inventario();
    }

    public void serAtacado(Object obj){
        if(obj instanceof Elfo){
            this.vida -= 8;
        }else if(obj instanceof Dwarf){
            if(inventario.existeItemComDescricao("Escudo Uruk-Hai")){
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

    private Item getItem(String descricao){
        return this.inventario.getItemPelaDescricao(descricao);
    }

    public void atacarInimigo(Object obj){
    }
}
