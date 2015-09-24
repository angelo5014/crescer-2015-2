import java.util.HashMap;
import java.util.ArrayList;
public class ExercitoDeElfos{
    private HashMap<String, Elfo> exercito;
    private HashMap<Status, ArrayList<Elfo>> exercitoOrdenado;
    
    public ExercitoDeElfos(){
        this.exercito = new HashMap<>();
    }

    public void alistarElfo(ElfoVerde verde){
        exercito.put(verde.getNome(),verde);
    }

    public void alistarElfo(ElfoNoturno nightcrawler){
        exercito.put(nightcrawler.getNome(),nightcrawler);
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
}
