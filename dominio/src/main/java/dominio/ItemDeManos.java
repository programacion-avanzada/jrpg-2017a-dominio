package dominio;

public class ItemDeManos extends Item{

	public ItemDeManos(int id_Item,int prioridad,String nombre) {
		this.id_Item=id_Item;
		this.prioridad=prioridad;
		this.nombre=nombre;
	}

	@Override
	public int obtenerModificacionFuerza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerModificacionDestreza() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerModificacionInteligencia() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerCantidadDeItemsMaximo() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	
	
}
