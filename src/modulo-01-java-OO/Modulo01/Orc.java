abstract class Orc extends Personagem{

    public Orc(){
    }

    public void receberAtaque(){
        if(existeItem("Escudo Uruk-Hai")){
            receberDano(6);
        }else{
            receberDano(10);
        }
    }

    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }

    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;

        return temArco && temFlechaProArco;
    }

    private void debitarFlecha() {
        Item flecha = getItem("Flecha");

        if(flecha.getQuantidade() == 1){
            this.inventario.perderItem(flecha);
        }
        else {
            flecha.debitarUmaUnidade();
        }
    }

    public void atacarDwarf(Dwarf dwarf){
        if(podeAtacarComEspada()){
            dwarf.receberAtaqueDoOrc(this);
        }else if(podeAtacarComArco()){
            dwarf.receberAtaqueDoOrc(this);
            debitarFlecha();
        }else{
            this.status = Status.FUGINDO;
        }
    }

    public void atacarElfo(Elfo elfo){
        if(podeAtacarComEspada()){
            elfo.receberAtaqueDoOrc(this);
        }else if(podeAtacarComArco()){
            elfo.receberAtaqueDoOrc(this);
            debitarFlecha();
        }else{
            this.status = Status.FUGINDO;
        }
    }

    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        if(podeAtacarComArco()){
            return 8;
        }
        return 0;
    }
}
