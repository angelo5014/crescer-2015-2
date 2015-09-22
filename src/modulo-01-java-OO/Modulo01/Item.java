public class Item{
    String descricao;
    int quantidade;
    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public boolean equals(Object obj){
        Item item = (Item)obj;
        return this.descricao.equals(item.getDescricao()) && this.quantidade == item.getQuantidade();
    }

    public void debitarUmaUnidade(){
        if(this.quantidade > 0){
            this.quantidade--;
        }
    }
}