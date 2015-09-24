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
        Item preferido = new Item("teste", 1);
        for(Item item : itens){
            if(item.getQuantidade()>maior){
                maior = item.getQuantidade();
                preferido = item;
            }
        }
        return preferido;
    }

    public void ordenarItens(){    
        for(int i = 0; i < itens.size(); i++) {
            for(int j = 0; j < (itens.size()-1) ; j++) {
                if(itens.get(j).getQuantidade() > itens.get(j+1).getQuantidade()) {
                    Item temp = itens.get(j);
                    itens.set(j, itens.get(j + 1));
                    itens.set(j + 1, temp);
                }
            }
        }
    }

    public boolean existeItemComDescricao(String descricao){
        boolean teste = false;
        for(Item item : itens){
            if(item.getDescricao().equals(descricao)){
                teste = true;
            }
        }
        return teste;
    }

    public Item getItemPelaDescricao(String descricao){
        Item teste = null;
        for(Item item : itens){
            if(item.getDescricao().equals(descricao)){
                teste = item;
            }
        }
        return teste;
    }

    public int retornarIndicePorNome(String descricao){
        return this.itens.indexOf(getItemPelaDescricao(descricao));
    }

    @Override
    public boolean equals(Object obj) {
        Inventario outroInventario = (Inventario)obj;
        return this.itens.equals(outroInventario.getItens());
    }
}