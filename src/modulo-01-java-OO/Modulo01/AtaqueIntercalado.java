import java.util.*;
public class AtaqueIntercalado implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

    public void atacar(HashMap<Status, ArrayList<Elfo>> exercito, ArrayList<Dwarf> alvos){
        ArrayList<Elfo> pelotao = exercito.get(Status.VIVO);

        for(Elfo elfo : organizarPelotao(pelotao)){
            this.ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : alvos){
                elfo.atacar(dwarf);
            }
        }
    }

    public ArrayList<Elfo> balancear(ArrayList<Elfo> pelotao){
        int contElfosVerdes = 0;
        int contElfosNoturnos = 0;
        ArrayList<Elfo> organizado = new ArrayList<>();

        for(Elfo elfo : pelotao){
            if(elfo instanceof ElfoVerde){
                contElfosVerdes++;
            }else{
                contElfosNoturnos++;            
            }
        }

        if(contElfosVerdes == contElfosNoturnos){
            return pelotao;
        }else if(contElfosVerdes > contElfosNoturnos){
            int maxElfosVerdes = contElfosNoturnos;
            int maxElfosNoturnos = contElfosNoturnos;
            int cont = 0;
            for(Elfo elfo : pelotao){
                if(elfo instanceof ElfoVerde && cont < maxElfosVerdes){
                    organizado.add(elfo);
                }else if(elfo instanceof ElfoNoturno && cont < maxElfosNoturnos){
                    organizado.add(elfo);
                }
            }
        }else{
            int maxElfosVerdes = contElfosNoturnos;
            int maxElfosNoturnos = contElfosNoturnos;
            int cont = 0;
            for(Elfo elfo : pelotao){
                if(elfo instanceof ElfoVerde && cont < maxElfosVerdes){
                    organizado.add(elfo);
                }else if(elfo instanceof ElfoNoturno && cont < maxElfosNoturnos){
                    organizado.add(elfo);
                }
            }
        }
        return organizado;
    }

    public ArrayList<Elfo> organizarPelotao(ArrayList<Elfo> pelotao){
        ArrayList<Elfo> organizado = new ArrayList<>();
        while(pelotao.size() > 0){
            if(pelotao.get(0) instanceof ElfoVerde){
                organizado.add(pelotao.get(0));
                pelotao.remove(0);
                boolean teste = true;
                int j = 0;
                while(teste){
                    if(pelotao.get(j) instanceof ElfoNoturno){
                        organizado.add(pelotao.get(j));
                        pelotao.remove(j);
                        teste = false;
                    }	
                    j++;
                }
            }   
        }
        return organizado;
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}
