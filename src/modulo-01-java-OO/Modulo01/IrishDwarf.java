public class IrishDwarf extends Dwarf{

    public IrishDwarf (){
        super();
    }

    public IrishDwarf (String nome){
        super(nome);
    }

    public IrishDwarf (String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }

    @Override
    public void tentarSorte(){
        if(getNumeroSorte()== -3333){
            for(Item item : inventario.getItens()){
                int pa = item.getQuantidade() * (item.getQuantidade()+1) / 2;
                item.setQuantidade(item.getQuantidade() + (1000 * pa));
            }

        }
    }

}