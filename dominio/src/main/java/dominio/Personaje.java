package dominio;

import java.util.Random;

public class Personaje implements Peleable {

	protected int salud;
	protected int energia;
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;
	protected Item[] itemsEquipados;
	protected Item[] itemsGuardados;
	protected int experiencia;
	protected int nivel;

	protected int defensa;
	protected int idPersonaje;
	protected int item_manos = 0;
	protected Alianza clan = null;

	public Personaje(String casta) {

	}

	public Personaje(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			Item[] itemsEquipados, Item[] itemsGuardados, int experiencia, int nivel, int idPersonaje, int defensa) {

		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.itemsEquipados = itemsEquipados;
		this.itemsGuardados = itemsGuardados;
		this.experiencia = experiencia;
		this.nivel = nivel;

		this.idPersonaje = idPersonaje;// agregue un Id para la base de datos
										// (nose si se va a implementar asi)
		this.defensa = defensa;// creo que es mas comodo tener un atributo
								// defensa que un metodo calcularPuntosDefensa
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public Item[] getItemsEquipados() {
		return itemsEquipados;
	}

	public void setItemsEquipados(Item[] itemsEquipados) {
		this.itemsEquipados = itemsEquipados;
	}

	public Item[] getItemsGuardados() {
		return itemsGuardados;
	}

	public void setItemsGuardados(Item[] itemsGuardados) {
		this.itemsGuardados = itemsGuardados;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void atacar(Peleable atacado) {
		Random rnd = new Random();
		if (rnd.nextDouble() <= this.getCasta().getProbabilidadGolpeCritico()) {
			System.out.println("GOLPE CRITICO!");
			atacado.serAtacado((int) (this.calcularPuntosDeAtaque() * this.getCasta().getDañoCritico()));// pego
																											// daño
																											// critico
		}
		atacado.serAtacado(this.calcularPuntosDeAtaque());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return true;
	}

	public int calcularPuntosDeAtaque() {
		int daño_items = 0;
		for (int i = 0; i < 6; i++) {
			if (this.itemsEquipados[i] != null)

				daño_items += this.itemsEquipados[i].getBono_daño();

		}
		System.out.println("Daño causado: " + (this.getFuerza() + daño_items));
		return (this.getFuerza() + daño_items); // hago que el daño de un
		// personaje sea igual a la
		// fuerza que tiene mas el daño
		// de sus items, luego hay que
		// modificarlo

	}

	public int calcularPuntosDeDefensa() {
		int defensa_items = 0;
		for (int i = 0; i < 6; i++) {
			if (this.itemsEquipados[i] != null)
				defensa_items += this.itemsEquipados[i].getBono_defensa();
		}
		System.out.println("Defensa obtenida: " + (this.getDefensa() * 0.5 + defensa_items + this.getDestreza()));
		return (int) (this.getDefensa() * 0.5 + defensa_items + this.getDestreza());
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int serAtacado(int daño) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.calcularPuntosDeDefensa();
			if (daño > 0) {
				salud -= daño;
				return daño;
			}
			return 0;// no le hace daño ya que la defensa fue mayor
		}
		System.out.println("GOLPE EVADIDO!");
		return 0;// esquivo el golpe
	}

	public void serDesernegizado(int daño) {
		energia -= daño;
	}

	public void serCurado(int salud) {
		this.salud += salud;
	}

	public void serEnergizado() {
		energia = 100;
	}

	public boolean desequiparItem(Item i) { // lo puedo usar para desequipar un
											// item o para dropear directamente
											// un item equipado
		for (int j = 0; j < 6; j++) {
			if (this.itemsEquipados[j].equals(i)) {
				this.itemsEquipados[j] = null;
				if (i.getClass().getName() == "dominio.ItemDeManos")
					this.item_manos--;
				return true;
			}
		}
		return false;
	}

	public boolean dropearItem(Item i) { // aca se dropearia desde la mochila
		for (int j = 0; j < 20; j++) {
			if (this.itemsGuardados[j].equals(i)) {
				this.itemsGuardados[j] = null;
				return true;
			}
		}
		return false;
	}

	public boolean guardarItem(Item i) {
		for (int j = 0; j < 20; j++) {
			if (this.itemsGuardados[j] == null) {
				this.itemsGuardados[j] = i;
				return true;
			}
		}
		return false;
	}

	public boolean equiparItem(Item i) {
		int j = 0;
		while (this.itemsEquipados[j] != null && j < 6)
			j++;
		if (j == 6) {
			System.out.println("Ya esta equipado al 100%");
			return false;
		}
		if (this.puedeEquipar(i)) {
			this.itemsEquipados[j] = i;
			return true;
		}
		return false;
	}

	public boolean puedeEquipar(Item i) {

		if (i.getClass().getName() == "dominio.ItemDeManos") {

			if (item_manos < 2) {
				item_manos++;
				return true;
			} else
				System.out.println("No puede equipar mas items del tipo " + i.getClass().getName());
			return false;
		}

		for (int j = 0; j < 6; j++) {
			if (this.itemsEquipados[j] != null) {
				if (this.itemsEquipados[j].getClass().getName() == i.getClass().getName()) {
					System.out.println("No puede equipar mas items del tipo " + i.getClass().getName());
					return false;

				}
			}
		}
		return true;
	}

	public String listaItemsEquipados() {
		String aux = "";
		for (Item i : this.itemsEquipados) {
			if (i != null)
				aux += i.toString();
		}
		return aux;

	}

	public String listaItemsGuardados() {
		String aux = "";
		for (Item i : this.itemsGuardados) {
			if (i != null)
				aux += i.toString();
		}
		return aux;

	}

	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public boolean aliar(Personaje nuevo_aliado) {
		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else
			System.out.println("NO SE PUEDE ALIAR YA QUE YA ESTA EN UNA ALIANZA");
		return false;
	}

	public boolean subirNivel() {
		if (this.nivel < 100) {
			this.nivel++;
			return true;
		} else {
			System.out.println("Maximo nivel alcanzado");
			return false;
		}
	}

	public void ganarExperiencia(int exp) {
		experiencia += exp;
	}

	/*
	 * public void habilidad1(Peleable atacado) { if(this.getCasta() instanceof
	 * Guerrero) { if(this.getEnergia()>10)// habria que ver cuanta energia
	 * consume cada habilidad {
	 * 
	 * Guerrero g1= (Guerrero)this.getCasta(); g1.golpeDoble(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Hechicero) { if(this.getEnergia()>10) {
	 * Hechicero h1= (Hechicero)this.getCasta(); h1.curar(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Asesino) { if(this.getEnergia()>10){
	 * Asesino a1= (Asesino)this.getCasta(); a1.golpeCritico(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * }
	 * 
	 * 
	 * public void habilidad2( Peleable atacado) { if(this.getCasta() instanceof
	 * Guerrero) { if(this.getEnergia()>10){ Guerrero g1=
	 * (Guerrero)this.getCasta(); g1.aumentarDefensa(this);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Hechicero) { if(this.getEnergia()>10){
	 * Hechicero h1= (Hechicero)this.getCasta(); h1.bolaDeFuego(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Asesino) { if(this.getEnergia()>10){
	 * Asesino a1= (Asesino)this.getCasta(); a1.perspicacia();
	 * this.setEnergia(this.getEnergia()-10); } } }
	 * 
	 * public void habilidad3(Peleable atacado) { if(this.getCasta() instanceof
	 * Guerrero) { if(this.getEnergia()>10){ Guerrero g1=
	 * (Guerrero)this.getCasta(); g1.ignoraDefensa(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Hechicero) { if(this.getEnergia()>10){
	 * Hechicero h1= (Hechicero)this.getCasta(); h1.quitarEnergia(this,
	 * atacado); this.setEnergia(this.getEnergia()-10); } }
	 * 
	 * if(this.getCasta() instanceof Asesino) { if(this.getEnergia()>10){
	 * Asesino a1= (Asesino)this.getCasta(); a1.robar(this, atacado);
	 * this.setEnergia(this.getEnergia()-10); } } }
	 */

	public void habilidadCasta1(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public void habilidadCasta2(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public void habilidadCasta3(Peleable atacado) {
		this.getCasta().habilidad1(this, atacado);
	}

	public static void main(String[] args) {
		Humano h = new Humano(100, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new Item[6], new Item[20], 0, 1, 1,
				50);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new Item[6], new Item[20], 0, 1, 1, 50);

		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(2, 10, "Cota de Malla", 0, 20, 0, 0, 0, 10, 10, 10);

		h.equiparItem(excalibur);
		System.out.println("Energia Humano:" + " " + h.getEnergia());
		System.out.println("Vida del Orco:" + " " + o.getSalud());

		// h.habilidadCasta1(o);
		h.atacar(o);

		System.out.println("Energia Humano:" + " " + h.getEnergia());
		System.out.println("Vida del Orco:" + " " + o.getSalud());

	}

}
