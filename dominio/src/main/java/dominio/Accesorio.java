package dominio;

public class Accesorio extends Item{

	public Accesorio(int id_Item, int prioridad, String nombre,String tipo, int bono_daño, int bono_defensa, int bono_magia,
			int bono_salud, int bono_energia, int fuerza_requerida, int inteligencia_requerida,
			int destreza_requerida) {
		super(id_Item, prioridad, nombre,tipo, bono_daño, bono_defensa, bono_magia, bono_salud, bono_energia, fuerza_requerida,
				inteligencia_requerida, destreza_requerida);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int obtenerCantidadDeItemsMaximo() {
		// TODO Auto-generated method stub
		return 1;
	}
public Item clone(){
	{
		
		Accesorio aux = new Accesorio(this.id_Item, this.prioridad, this.nombre, this.tipo, this.bono_daño, this.bono_defensa,
				this.bono_magia, this.bono_salud, this.bono_energia, this.fuerza_requerida,
				this.inteligencia_requerida, this.destreza_requerida);
	return aux;
}
}
}
