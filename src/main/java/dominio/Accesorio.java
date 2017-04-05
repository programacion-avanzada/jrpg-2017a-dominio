package dominio;

public class Accesorio extends Item {

	public Accesorio(int idItem, int prioridad, String nombre, String tipo, int bonoDaño, int bonoDefensa,
			int bonoMagia, int bonoSalud, int bonoEnergia, int fuerzaRequerida, int inteligenciaRequerida,
			int destrezaRequerida) {
		super(idItem, prioridad, nombre, tipo, bonoDaño, bonoDefensa, bonoMagia, bonoSalud, bonoEnergia,
				fuerzaRequerida, inteligenciaRequerida, destrezaRequerida);
	}

	public int obtenerCantidadDeItemsMaximo() {
		return 1;
	}

	public Item clone() {
		return new Accesorio(this.idItem, this.prioridad, this.nombre, this.tipo, this.bonoDaño, this.bonoDefensa,
				this.bonoMagia, this.bonoSalud, this.bonoEnergia, this.fuerzaRequerida, this.inteligenciaRequerida,
				this.destrezaRequerida);
	}
}
