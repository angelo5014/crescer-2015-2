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
}