import java.util.ArrayList;
public class Inventario{
    private ArrayList<Item> itens = new ArrayList<>();
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public void perderItem(Item item){
        itens.remove(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.itens;
    }

}