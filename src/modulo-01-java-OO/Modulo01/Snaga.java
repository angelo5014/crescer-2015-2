public class Snaga extends Orc{
    public Snaga(){
        this(null);
    }

    public Snaga(String nome){
        super();
        this.nome = nome;
        this.vida = 70;
        this.experiencia = 0;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.inventario.adicionarItem( new Item ("Arco",1));
        this.inventario.adicionarItem(new Item ("Flecha",5));
    }
}
