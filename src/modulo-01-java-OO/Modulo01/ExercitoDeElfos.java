import java.util.HashMap;
import java.util.ArrayList;
public class ExercitoDeElfos{
    private HashMap<String, Elfo> exercito;
    private HashMap<Status, ArrayList<Elfo>> exercitoOrdenado;

    EstrategiaDeAtaque estrategia;

    public ExercitoDeElfos(){
        this.exercito = new HashMap<>();
        estrategia = new EstrategiaNormal();
    }

    public void alistar(Elfo elfo){
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar){
            exercito.put(elfo.getNome(),elfo);
        }
    }

    public Elfo getElfoPorNome(String nome){
        return this.exercito.get(nome);
    }

    public void agruparPorStatus(){
        exercitoOrdenado = new HashMap<>();
        for(Elfo elfo : exercito.values()){
            if(!exercitoOrdenado.containsKey(elfo.getStatus())){
                exercitoOrdenado.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
            exercitoOrdenado.get(elfo.getStatus()).add(elfo);
        }
    }

    public ArrayList<Elfo> buscar(Status status){
        return exercitoOrdenado.get(status);
    }

    public HashMap<String, Elfo> getExercito(){
        return this.exercito;
    }

    public HashMap<Status, ArrayList<Elfo>> getExercitoOrdenado(){
        return this.exercitoOrdenado;
    }

    public boolean equals(Object obj){
        ExercitoDeElfos outro = (ExercitoDeElfos)obj;
        return this.exercito.equals(outro.getExercito());
    }

    public void atacar(ArrayList<Dwarf> alvos) {
        agruparPorStatus();
        estrategia.atacar(this.exercitoOrdenado,alvos);
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
    
    public void mudarEstrategiaDeAtaque(EstrategiaDeAtaque estrategia){
        this.estrategia = estrategia;
    }
}
