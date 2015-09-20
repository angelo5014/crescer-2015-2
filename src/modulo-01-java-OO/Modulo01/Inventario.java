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
    
    public String getDescricoesItens(){
        String retorno = "";
        int cont = 1;
            for(Item item : this.itens){
                retorno += item.getDescricao() + (cont != this.itens.size() ? "," : "");
                cont++;
            }
            return retorno;
    }
    
    public Item getItemComMaiorQuantidade(){
        int maior = 0;
        Item preferido = new Item(1, "teste");
        for(Item item : itens){
            if(item.getQuantidade()>maior){
                maior = item.getQuantidade();
                preferido = item;
            }
       }
       return preferido;
    }
}