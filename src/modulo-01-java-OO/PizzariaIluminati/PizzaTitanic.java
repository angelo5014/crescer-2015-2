public class PizzaTitanic extends Pizza{
    private String[] sabores = new String[6];
    
    public PizzaTitanic(String[]sabores){
        for(int i = 0;i<sabores.length;i++){
            this.sabores[i] = sabores[i];
        }
        this.preco = 100;
        this.nome = "Pizza Titanic";
    }
}
