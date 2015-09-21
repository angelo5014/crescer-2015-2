public class IrishDwarf extends Dwarf{
    private int vida = 110;
    private Status status;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario = new Inventario();

    public IrishDwarf (){
    }

    public IrishDwarf (String nome){
    }

    public IrishDwarf (String nome, DataTerceiraEra dataNascimento){
    }

    public void tentarSorte(){
        if(getNumeroSorte()== -3333){
            for(Item item : inventario.getItens()){
                int pa = item.getQuantidade() * (item.getQuantidade()+1) / 2;
                item.setQuantidade(item.getQuantidade() + 1000 * pa);
            }
        }
    }

}