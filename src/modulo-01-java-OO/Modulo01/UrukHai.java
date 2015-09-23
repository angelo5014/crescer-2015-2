public class UrukHai extends Orc{
    public UrukHai(){
        super();
        this.vida = 150;
        this.status = Status.VIVO;
        this.inventario.adicionarItem(new Item("Espada", 1));
        this.inventario.adicionarItem(new Item("Escudo Uruk-Hai", 1));
    } 
}