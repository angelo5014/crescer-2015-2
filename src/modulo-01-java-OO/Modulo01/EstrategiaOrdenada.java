import java.util.ArrayList;
import java.util.HashMap;

public class EstrategiaOrdenada implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(HashMap<Status, ArrayList<Elfo>> exercito, ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> pelotao = exercito.get(Status.VIVO);
        
        int intencoes = pelotao.size() * dwarves.size();
        int cont = 0;
        int metade = pelotao.size()/2;
        
        ArrayList <Elfo> organizado = new ArrayList<>(pelotao.size());
        
        for(Elfo elfo : pelotao){
            if(elfo instanceof ElfoVerde){
                if(organizado.get(cont) == null){
                    organizado.add(cont, elfo);
                }else{
                    organizado.add(cont + 1, elfo);
                }
            }else{
                if(elfo instanceof ElfoNoturno){
                    
                }
            }
        }

        for(Elfo elfo : pelotao){
            this.ordemDoUltimoAtaque.add(elfo);
            if(elfo instanceof ElfoNoturno){
                if(cont < 0.3 * intencoes){
                    cont++;
                    for(Dwarf dwarf: dwarves){
                        elfo.atacar(dwarf);
                    }
                }
            }else{
                for(Dwarf dwarf: dwarves){
                    elfo.atacar(dwarf);
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}
