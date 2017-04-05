package dominio;

import java.util.Random;

public class NonPlayableCharacter implements Peleable {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private Item[] itemsDropeables;
	private int nivel;
	private static final int cantidadItemsDropeables = 3;
	private static final int dificultadAleatoria = -1;

	public NonPlayableCharacter(String nombre, int nivel, Item[] itemsDropeables, int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		if (itemsDropeables != null)
			this.itemsDropeables = itemsDropeables.clone();
		else
			this.itemsDropeables = new Item[cantidadItemsDropeables];
		Random rnd = new Random();
		int dificultad;
		if (dificultadNPC == dificultadAleatoria)
			dificultad = rnd.nextInt(3);
		else
			dificultad = dificultadNPC;

		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3;// 30%
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6;// 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10;// 50%
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;

		}
	}
		

	public int otorgarExp() {
		return this.nivel * 30;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int atacar(Peleable atacado) {
		Random rnd = new Random();
		if (rnd.nextDouble() <= 0.15) {// los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else
			return atacado.serAtacado(this.getAtaque());
	}

	public int serAtacado(int daño) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= 0.15) {
			daño -= this.getDefensa() / 2;
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		return 0;// esquivo el golpe
	}

	public void despuesDeTurno() {

	}

	public Item dropearItemAleatorio() {
		Random rnd = new Random();
		int numeroDeItemDropeado = rnd.nextInt(itemsDropeables.length);
		if (itemsDropeables != null) {
			int nivelItem = rnd.nextInt(this.nivel + 6);
			while ((this.nivel - 5) > nivelItem || (this.nivel + 5) < nivelItem)
				nivelItem = rnd.nextInt(this.nivel + 6);
			return modificarItem(itemsDropeables[numeroDeItemDropeado], nivelItem);
		}
		return null;
	}

	public Item modificarItem(Item itemDropeado, int nivelItem) {
		Item itemModificado = itemDropeado.clone();
		itemModificado.setNivel(nivelItem);
		if (itemModificado.getBonoDaño() != 0)
			itemModificado.setBonoDaño(itemModificado.getBonoDaño() + nivelItem);
		if (itemModificado.getBonoDefensa() != 0)
			itemModificado.setBonoDefensa(itemModificado.getBonoDefensa() + nivelItem);
		if (itemModificado.getBonoMagia() != 0)
			itemModificado.setBonoMagia(itemModificado.getBonoMagia() + nivelItem);
		if (itemModificado.getBonoSalud() != 0)
			itemModificado.setBonoSalud(itemModificado.getBonoSalud() + nivelItem);
		if (itemModificado.getBonoEnergia() != 0)
			itemModificado.setBonoEnergia(itemModificado.getBonoEnergia() + nivelItem);
		return itemModificado;
	}

	public Item serRobado() {
		Random rnd = new Random();
		return this.itemsDropeables[rnd.nextInt(this.itemsDropeables.length)].clone();
	}

	public void ganarExperiencia(int exp) {

	}

	@Override
	public int getAtaque() {
		return fuerza;
	}

	@Override
	public void setAtaque(int ataque) {
		this.fuerza = ataque;
	}
}
