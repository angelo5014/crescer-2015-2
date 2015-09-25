import java.util.HashMap;
import java.util.ArrayList;
public interface EstrategiaDeAtaque{
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
    void atacar(HashMap<Status, ArrayList<Elfo>> exercito,ArrayList<Dwarf> dwarves);
}
