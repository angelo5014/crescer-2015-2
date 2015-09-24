import java.util.*;
public class ElfoVerde extends Elfo{

    public ElfoVerde(String nome){
        super(nome);
    }

    public void adicionarItem(Item item){
        ArrayList<String> validas = 
            new ArrayList<String>(
                Arrays.asList(new String[] { 
                        "Espada de aço valiriano", "Arco e Flecha de Vidro"
                    })
            );

        boolean podeAdicionar = item != null && validas.contains(item.getDescricao());

        if (podeAdicionar) {
            super.adicionarItem(item);
        }
    }   

    public void atacar(Object obj){
        super.atacar(obj);
        experiencia++;
    }

}