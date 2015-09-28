import java.util.ArrayList;
import java.util.HashMap;

public class EstrategiaOrdenada implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

    public void atacar(HashMap<Status, ArrayList<Elfo>> exercito, ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> pelotao = exercito.get(Status.VIVO);
        ArrayList<Elfo> organizado = organizarPelotao(pelotao);
        for(Elfo elfo : organizado){
            this.ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf: dwarves){
                elfo.atacar(dwarf);
            }
        }
    }

    public ArrayList<Elfo> organizarPelotao(ArrayList<Elfo> pelotao){
        ArrayList <Elfo> organizado = new ArrayList<>();
        
        for(Elfo elfo : pelotao){
            if(elfo instanceof ElfoVerde){
                organizado.add(elfo);
            }
        }

        for(Elfo elfo : pelotao){
            if(elfo.getClass().getName().equals("Elfo")){
                organizado.add(elfo);
            }
        }

        for(Elfo elfo : pelotao){
            if(elfo instanceof ElfoNoturno){
                organizado.add(elfo);
            }
        }      
        return organizado;
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}