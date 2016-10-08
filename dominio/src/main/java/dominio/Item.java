package dominio;

public abstract class Item {
protected int id_Item ;
protected int prioridad;
protected String nombre;

public abstract int obtenerModificacionFuerza();
public abstract int obtenerModificacionDestreza();
public abstract int obtenerModificacionInteligencia();
public abstract int obtenerCantidadDeItemsMaximo();
}
