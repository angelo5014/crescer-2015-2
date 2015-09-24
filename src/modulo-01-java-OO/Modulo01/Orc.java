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
        if(flecha!=null){
            if(flecha.getQuantidade() == 1){
                this.inventario.perderItem(flecha);
            }
            else {
                flecha.debitarUmaUnidade();
            }
        }
    }

    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }else if(podeAtacarComArco()){
            return 8;
        }else{
            return 0;
        }
    }

    public void atacar(Object obj){
        if(podeAtacarComEspada() || podeAtacarComArco()){
        super.atacar(obj);
        if(!podeAtacarComEspada()){
            debitarFlecha();
        }
    }else{
        this.status = Status.FUGINDO;
    }
}
}
