package dominio;

public abstract class Item {
	protected int idItem;
	protected int prioridad;
	protected String nombre;
	protected String tipo;

	protected int bonoDaño;
	protected int bonoDefensa;
	protected int bonoMagia;
	protected int bonoSalud;
	protected int bonoEnergia;
	protected int fuerzaRequerida;
	protected int inteligenciaRequerida;
	protected int destrezaRequerida;
	protected int nivel = 1;


	public Item(int id_Item, int prioridad, String nombre, String tipo, int bono_daño, int bono_defensa, int bono_magia,
			int bono_salud, int bono_energia, int fuerza_requerida, int inteligencia_requerida,
			int destreza_requerida) {
		this.idItem = id_Item;
		this.prioridad = prioridad;
		this.nombre = nombre;
		this.tipo = tipo;
		this.bonoDaño = bono_daño;
		this.bonoDefensa = bono_defensa;
		this.bonoMagia = bono_magia;
		this.bonoSalud = bono_salud;
		this.bonoEnergia = bono_energia;
		this.fuerzaRequerida = fuerza_requerida;
		this.destrezaRequerida = destreza_requerida;
		this.inteligenciaRequerida = inteligencia_requerida;
	}

	public int getId_Item() {
		return idItem;
	}

	public void setId_Item(int id_Item) {
		this.idItem = id_Item;
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

	public int getBonoDaño() {
		return bonoDaño;
	}

	public void setBonoDaño(int bonoDaño) {
		this.bonoDaño = bonoDaño;
	}

	public int getBonoDefensa() {
		return bonoDefensa;
	}

	public void setBonoDefensa(int bonoDefensa) {
		this.bonoDefensa = bonoDefensa;
	}

	public int getBonoMagia() {
		return bonoMagia;
	}

	public void setBonoMagia(int bonoMagia) {
		this.bonoMagia = bonoMagia;
	}

	public int getBonoSalud() {
		return bonoSalud;
	}

	public void setBonoSalud(int bonoSalud) {
		this.bonoSalud = bonoSalud;
	}

	public int getBonoEnergia() {
		return bonoEnergia;
	}

	public void setBonoEnergia(int bonoEnergia) {
		this.bonoEnergia = bonoEnergia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}

	public void setFuerzaRequerida(int fuerzaRequerida) {
		this.fuerzaRequerida = fuerzaRequerida;
	}

	public int getInteligenciaRequerida() {
		return inteligenciaRequerida;
	}

	public void setInteligenciaRequerida(int inteligenciaRequerida) {
		this.inteligenciaRequerida = inteligenciaRequerida;
	}

	public int getDestrezaRequerida() {
		return destrezaRequerida;
	}

	public void setDestrezaRequerida(int destrezaRequerida) {
		this.destrezaRequerida = destrezaRequerida;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public abstract Item clone(); 

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
}
