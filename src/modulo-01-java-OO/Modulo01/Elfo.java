/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo extends Personagem{
    public Elfo(){
        this(null);
    }
    
      public Elfo(String nome) {
        this(nome, 42);
    }

    public Elfo(String nome, int flechas){
        this.vida = 100;
        this.nome = nome;
        this.status = Status.VIVO;
        this.experiencia = 0;
        inventario.getItens().add(new Item("Flecha", flechas));
    }

    public String toString(){
        boolean flechaNoSingular = getItem("Flecha").getQuantidade() != 1;
        boolean nivelNoSingular = this.experiencia != 1;

        String textoFormatado = String.format("%s possui %d %s e %d %s de experiência.", 
                this.nome,
                this.getItem("Flecha").getQuantidade(),
                flechaNoSingular ? "flechas" : "flecha",
                this.experiencia,
                nivelNoSingular ? "níveis" : "nível"
            );

        return textoFormatado;//this.nome + " possui " + this.flechas + " " + textoFlechas + " e " + this.experiencia + " " +textoNiveis + " de experiencia";
    }
    
    public void receberAtaque(Object obj){
        if(obj instanceof Dwarf){
            //Ainda não foi pedido para o Dwarf atacar o Elfo
        }else if (obj instanceof Orc){
            Orc orc = (Orc)obj;
            int dano = orc.getDanoDeAtaque();
            this.vida -= dano;
        }
    }
    
    public void atacar(Object obj){
        super.atacar(obj);
        super.getItem("Flecha").debitarUmaUnidade();
        this.experiencia++;
    }
    
    public void adicionarItem(Item item){
        inventario.getItens().add(item);
    }

    public void perderItem(Item item){
        inventario.getItens().remove(item);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getVida(){
        return this.vida;
    }

    public int getFlechas(){
        return getItem("Flecha").getQuantidade();
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public Status getStatus(){
        return this.status;
    }
}