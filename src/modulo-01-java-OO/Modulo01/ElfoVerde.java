public class ElfoVerde extends Elfo{

    public ElfoVerde(String nome){
        super(nome);
    }

    public void atirarFlechas(Object obj){
        if(obj instanceof Dwarf){
            Dwarf dwarf = (Dwarf)obj;
            this.flechas--;
            dwarf.receberFlechada();
            experiencia +=2;
        }else if(obj instanceof UrukHai){
            UrukHai urukHai = (UrukHai)obj;
            urukHai.serAtacado(this);
        }else if(obj instanceof Snaga){
            Snaga snaga = (Snaga)obj;
            snaga.serAtacado(this);
        }
    }
    
    public void adicionarItem(Item item){
        boolean podeAdicionar = item.getDescricao().equals("Espada de aço valiriano")
        ||
        item.getDescricao().equals("Arco e flecha de vidro")
        ;
    }
    
}