import java.util.ArrayList;

public class Pedido{
    private Cliente cliente;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private double total;
    private double pagamento;
    boolean entrega = true;
    double desconto  = 0;

    public Pedido(Cliente cliente, double pagamento){
        this.cliente = cliente;
        this.pagamento = pagamento;
    }

    public void adicionarProduto(Produto produto){
        this.produtos.add(produto);
    }

    public double getTroco(){
        valorTotal();
        if(this.pagamento == total){
            return 0;
        }else{
            return (this.pagamento - this.total);
        }
    }

    public void valorTotal(){
        double total = 0;
        for(Produto produto : produtos){
            total += produto.getPreco();
        }

        if(total > 60){
            entrega = false;
        }
        if(total > 100){
            total = total - (total * 10)/100;
            desconto = total;
        }
        if(total<60){
            total += 4.50;
        }
        this.total = total;
    }

    public void imprimirComprovante(){
        valorTotal();
        System.out.println(cliente.getNome());
        System.out.println(cliente.getEndereco());
        System.out.println(cliente.getTelefone());
        System.out.println(this.total);
        System.out.println(getTroco());
        for(Produto produto : produtos){
            System.out.println(produto.getNome() + " R$" +produto.getPreco());
        }
        if(entrega){
            System.out.println("Entrega R$ 4,50");
        }
        if(desconto > 0){
            System.out.println("Desconto de " + desconto);
        }
    }

}
