package dominio;

public class Batallon {
	
	Peleable [] aliados;
	String alianza;
	
	
	
	public Peleable[] getAliados() {
		return aliados;
	}

	public void setAliados(Peleable[] aliados) {
		this.aliados = aliados;
	}

	public String getAlianza() {
		return alianza;
	}

	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}

	public int cantidad_luchadores()
	{
		return aliados.length;
	}
	
	public void establecerEstrategia(){
		
	}
}
