public class Item{
    String descricao;
    int quantidade;
    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
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

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void debitarUmaUnidade(){
        if(this.quantidade > 0){
            this.quantidade--;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
}