/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo extends Personagem{
    protected int flechas;
    
    public Elfo(String nome) {
        this(nome, 42);
    }

    public Elfo(String nome, int flechas){
        this.vida = 80;
        this.nome = nome;
        this.flechas = flechas;
        this.status = Status.VIVO;
        inventario = new Inventario();
    }

    public void atirarFlechas(Object obj){
        if(obj instanceof Dwarf){
            Dwarf dwarf = (Dwarf)obj;
            flechas--;
            dwarf.receberFlechada();
            experiencia++;
        }else if(obj instanceof UrukHai){
            UrukHai urukHai = (UrukHai)obj;
            urukHai.serAtacado(this);
        }else if(obj instanceof Snaga){
            Snaga snaga = (Snaga)obj;
            snaga.serAtacado(this);
        }
    }

    public String toString(){
        boolean flechaNoSingular = this.flechas != 1;
        boolean nivelNoSingular = this.experiencia != 1;

        String textoFormatado = String.format("%s possui %d %s e %d %s de experiencia", 
                this.nome,
                this.flechas,
                flechaNoSingular ? "flechas" : "flecha",
                this.experiencia,
                nivelNoSingular ? "níveis" : "nível"
            );

        return textoFormatado;//this.nome + " possui " + this.flechas + " " + textoFlechas + " e " + this.experiencia + " " +textoNiveis + " de experiencia";
    }

    public void serAtacado(Object obj){
        if(obj instanceof UrukHai){
            this.vida -= 12;
        }else if(obj instanceof Snaga){
            this.vida -= 8;
        }
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
    
    public int getVida(){
        return this.vida;
    }

    public int getFlechas(){
        return this.flechas;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public Status getStatus(){
        return this.status;
    }
}