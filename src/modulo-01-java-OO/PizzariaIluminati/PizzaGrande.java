public class PizzaGrande extends Pizza{
    private String sabor1, sabor2;
    public PizzaGrande(String sabor1){
        this(sabor1, null);
    }
    
    public PizzaGrande(String sabor1, String sabor2){
        this.sabor1 = sabor1;
        this.sabor2 = sabor2;
        this.preco = 40;
        this.nome = "Pizza Grande";
    }
}
