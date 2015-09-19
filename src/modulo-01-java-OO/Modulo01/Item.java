public class Item{
    String descricao;
    int quantidade;
    public Item(int quantidade, String descricao){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public boolean equals(Object obj){
        Item item = (Item)obj;
        return this.descricao.equals(item.getDescricao()) && this.quantidade == item.getQuantidade();
    }
}