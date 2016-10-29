package dominio;

import java.util.LinkedList;

import javax.sound.midi.Synthesizer;

public class Orco extends Personaje {

	public Orco(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		salud_tope += 10;
		salud = salud_tope;
		energia = energia_tope;
	}

	public Orco(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel,
			int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, itemsEquipados, itemsGuardados,
				experiencia, nivel, idPersonaje);

	}

	public boolean habilidadRaza1(Peleable atacado) { // Golpe Defensa
		if (this.getEnergia() > 10){
			this.setEnergia(this.getEnergia() - 10);
			atacado.serAtacado(this.getDefensa()*2);
			return true;
			}
	
		return false;
	}

	public boolean habilidadRaza2(Peleable atacado) {// mordisco de vida
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int daño_causado = atacado.serAtacado(this.getFuerza());// solo
																	// depende
																	// de la
																	// fuerza
			if (daño_causado != 0) {
				this.serCurado(daño_causado);// se cura con el daño que le causo
												// al oponente
				return true;
			}
		}
		return false;
	}

}
