public class ElfoVerde extends Elfo{

    public ElfoVerde(String nome){
        super(nome);
    }

    public void adicionarItem(Item item){
        boolean podeAdicionar = item.getDescricao().equals("Espada de aço valiriano")
        ||
        item.getDescricao().equals("Arco e flecha de vidro")
        ;
    }
    
    public void atacar(Object obj){
        super.atacar(obj);
        experiencia++;
    }
    
}