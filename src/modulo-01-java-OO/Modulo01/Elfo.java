public class Elfo {
    private String nome;
    private int flechas;
    private experiencia = 0;
    
    public Elfo(String n) {
        nome = n;
        flechas = 42;
    }
	
    public Elfo(String n, int flech){
        nome = n;
        flechas = flech;
    }
	
    public atirarFlechas(){
		experiencia++;
		flechas--;
    }
	
	public atirarFlechaRefactory(this.flechas, this.experiencia){
		flechas--;
		if(boolean acertar == true)
			experiencia++;
	}
}