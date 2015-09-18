public class DataTerceiraEra{
    private int dia;
    private int mes;
    private int ano;
    
    public DataTerceiraEra(int dia, int mes, int ano){
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
    }
    
    public boolean ehBissexto(){
    return (this.ano % 4 == 0) && (this.ano % 100 != 0) || (this.ano %400 == 0) ? true : false;
    }
    
    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }
}