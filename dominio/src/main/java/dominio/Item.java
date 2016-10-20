package dominio;

public abstract class Item {
protected int id_Item ;
protected int prioridad;
protected String nombre;
protected String tipo;/////////////HAY Q AGREGARLO AL CONSTRUCTTTTTTT

protected int bono_daño;
protected int bono_defensa;
protected int bono_magia;
protected int bono_salud;
protected int bono_energia;
protected int fuerza_requerida;
protected int inteligencia_requerida;
protected int destreza_requerida;
public abstract int obtenerCantidadDeItemsMaximo();



public Item(int id_Item, int prioridad, String nombre, String tipo, int bono_daño, int bono_defensa, int bono_magia, int bono_salud,
		int bono_energia,int fuerza_requerida,int inteligencia_requerida,int destreza_requerida) {
	this.id_Item = id_Item;
	this.prioridad = prioridad;
	this.nombre = nombre;
	this.tipo=tipo;
	this.bono_daño = bono_daño;
	this.bono_defensa = bono_defensa;
	this.bono_magia = bono_magia;
	this.bono_salud = bono_salud;
	this.bono_energia = bono_energia;
	this.fuerza_requerida= fuerza_requerida;
	this.destreza_requerida= destreza_requerida;
	this.inteligencia_requerida = inteligencia_requerida;
}



public int getId_Item() {
	return id_Item;
}
public void setId_Item(int id_Item) {
	this.id_Item = id_Item;
}
public int getPrioridad() {
	return prioridad;
}
public void setPrioridad(int prioridad) {
	this.prioridad = prioridad;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getBono_daño() {
	return bono_daño;
}
public void setBono_daño(int bono_daño) {
	this.bono_daño = bono_daño;
}
public int getBono_defensa() {
	return bono_defensa;
}
public void setBono_defensa(int bono_defensa) {
	this.bono_defensa = bono_defensa;
}
public int getBono_magia() {
	return bono_magia;
}
public void setBono_magia(int bono_magia) {
	this.bono_magia = bono_magia;
}
public int getBono_salud() {
	return bono_salud;
}
public void setBono_salud(int bono_salud) {
	this.bono_salud = bono_salud;
}
public int getBono_energia() {
	return bono_energia;
}
public void setBono_energia(int bono_energia) {
	this.bono_energia = bono_energia;
}



public String getTipo() {
	return tipo;
}



public void setTipo(String tipo) {
	this.tipo = tipo;
}



public int getFuerza_requerida() {
	return fuerza_requerida;
}



public void setFuerza_requerida(int fuerza_requerida) {
	this.fuerza_requerida = fuerza_requerida;
}



public int getInteligencia_requerida() {
	return inteligencia_requerida;
}



public void setInteligencia_requerida(int inteligencia_requerida) {
	this.inteligencia_requerida = inteligencia_requerida;
}



public int getDestreza_requerida() {
	return destreza_requerida;
}



public void setDestreza_requerida(int destreza_requerida) {
	this.destreza_requerida = destreza_requerida;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + bono_daño;
	result = prime * result + bono_defensa;
	result = prime * result + bono_energia;
	result = prime * result + bono_magia;
	result = prime * result + bono_salud;
	result = prime * result + destreza_requerida;
	result = prime * result + fuerza_requerida;
	result = prime * result + id_Item;
	result = prime * result + inteligencia_requerida;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	result = prime * result + prioridad;
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	return true;
}

public String toString ()
{
	return this.nombre+"  Daño:"+this.bono_daño+"  Defensa:"+this.bono_defensa+"  Magia:"+this.bono_magia+"  Salud:"+this.bono_salud+"  Energia:"+this.bono_energia+"\n";
}

}
