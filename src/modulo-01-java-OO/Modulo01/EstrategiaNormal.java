import java.util.ArrayList;
import java.util.HashMap;

public class EstrategiaNormal implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(HashMap<Status, ArrayList<Elfo>> exercito, ArrayList<Dwarf> dwarves){
        ArrayList<Elfo> pelotao = exercito.get(Status.VIVO);
        int intencoes = pelotao.size() * dwarves.size();
        int cont = 0;

        for(Elfo elfo : pelotao){
            this.ordemDoUltimoAtaque.add(elfo);
            if(elfo instanceof ElfoNoturno){
                if(cont < (int)(0.3 * intencoes)){
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
