package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Personaje implements Peleable {

	protected int salud;
	protected int energia;
	protected int defensa;//depende de la destreza
	//protected int ataque;//depende de la fuerza
	//protected int magia;//depende de la inteligencia
	
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected LinkedList<Item> itemsEquipados;
	protected LinkedList<Item> itemsGuardados;
	protected int experiencia;
	protected int nivel;

	
	protected int idPersonaje;
	protected int item_manos = 0;
	protected Alianza clan = null;
	protected int salud_tope;// nose si va
	protected int energia_tope;// nose si va
	protected static int tabla_nivel[];

	public static void cargar_tabla_nivel() {
		Personaje.tabla_nivel = new int[100];
		Personaje.tabla_nivel[0] = 0;
		for (int i = 1; i < 100; i++)
			Personaje.tabla_nivel[i] = Personaje.tabla_nivel[i - 1] + 50;
	}

	public Personaje(String casta) {

	}

	public Personaje(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel,
			int idPersonaje, int defensa) {

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

	public LinkedList<Item> getItemsEquipados() {
		return itemsEquipados;
	}

	public void setItemsEquipados(LinkedList<Item> itemsEquipados) {
		this.itemsEquipados = itemsEquipados;
	}

	public LinkedList<Item> getItemsGuardados() {
		return itemsGuardados;
	}

	public void setItemsGuardados(LinkedList<Item> itemsGuardados) {
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
		if (rnd.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {/// estoy
																									/// sacando
																									/// el
																									/// 10%
																									/// de
																									/// la
																									/// destreza
																									/// para
																									/// aumentar
																									/// la
																									/// prob
																									/// de
																									/// critico
			System.out.println("GOLPE CRITICO!");
			atacado.serAtacado((int) (this.calcularPuntosDeAtaque() * this.getCasta().getDañoCritico()));// pego
																											// daño
																											// critico
		} else
			atacado.serAtacado(this.calcularPuntosDeAtaque());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return true;
	}

	public int calcularPuntosDeAtaque() {
		int daño_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			daño_items += it.next().bono_daño;
		System.out.println("Daño causado: " + (this.getFuerza() + daño_items));
		return (this.getFuerza() + daño_items); // hago que el daño de un
		// personaje sea igual a la
		// fuerza que tiene mas el daño
		// de sus items, luego hay que
		// modificarlo

	}

	public int calcularPuntosDeDefensa() {
		int defensa_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			defensa_items += it.next().bono_defensa;
		System.out.println("Defensa obtenida: " + (this.getDefensa() * 0.5 + defensa_items + this.getDestreza()));
		return (int) (defensa_items + this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		int magia_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			magia_items += it.next().bono_magia;
		System.out.println("Magia obtenida: " + (this.getInteligencia() + magia_items));
		return (this.getInteligencia() + magia_items);

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

	public int serRobadoSalud(int daño) {
		daño -= this.calcularPuntosDeDefensa();
		if (daño <= 0)
			return 0;
		if ((salud - daño) >= 0)
			salud -= daño;
		else
			{daño = salud;// le queda menos salud que el daño inflingido
			salud=0;
			}
		return daño;
	}

	public int serDesernegizado(int daño) {
		daño -= this.calcularPuntosDeDefensa();
		if (daño <= 0)
			return 0;
		if ((energia - daño) >= 0)
			energia -= daño;
		else
			{daño = energia;// le queda menos energia que el daño inflingido
			energia=0;
			}
		return daño;
	}

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.salud_tope)
			this.salud += salud;
		else
			this.salud = salud_tope;
	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energia_tope)
			this.energia += energia;
		else
			this.energia = energia_tope;
	}

	public boolean desequiparItem(Item i) { // lo puedo usar para desequipar un
											// item o para dropear directamente
		// un item equipado
		if (this.itemsEquipados.remove(i)) {
			if (i.getTipo() == "Manos")
				this.item_manos--;
			return true;
		}
		return false;
	}

	public boolean dropearItemMochila(Item i) { // aca se dropearia desde la
												// mochila
		return this.itemsGuardados.remove(i);
	}

	public boolean guardarItem(Item i) {

		if (this.itemsGuardados.size() <= 20) {
			this.itemsGuardados.add(i);
			return true;
		}
		return false;
	}

	public boolean equiparItem(Item i) {
		if (this.itemsEquipados.size() <= 6) {
			if (this.puedeEquipar(i)) {
				this.itemsEquipados.add(i);

				return true;
			}

		}

		return false;
	}

	public boolean puedeEquipar(Item i) {
		if (this.fuerza < i.getFuerza_requerida() || this.destreza < i.getDestreza_requerida()
				|| this.inteligencia < i.getInteligencia_requerida())
			return false;
		if (i.getTipo() == "Manos") {
			if (item_manos < 2) {
				item_manos++;
				return true;
			}
			return false;
		}

		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext()) {
			if (it.next().getTipo() == i.getTipo())
				return false;
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

	public Item serRobado() {
		int num_item_desequipado;
		Item item_robado;
		if (this.itemsEquipados.size() == 0 && this.itemsGuardados.size() == 0)
			return null;

		Random rnd = new Random();

		if (rnd.nextInt(2) == 0)// 0=itemsEquipados, 1=itemsGuardados
		{
			if (this.itemsEquipados.size() != 0) {
				num_item_desequipado = rnd.nextInt(this.itemsEquipados.size());
				item_robado = this.itemsEquipados.get(num_item_desequipado);
				this.desequiparItem(item_robado);
				return item_robado;
			}
		}
		num_item_desequipado = rnd.nextInt(this.itemsGuardados.size());
		item_robado = this.itemsGuardados.get(num_item_desequipado);
		this.dropearItemMochila(item_robado);
		return item_robado;
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

	public void asignarPuntos() {
		int puntos = this.nivel / 10 + 1;
		int p_fuerza, p_inteligencia, p_destreza;
		System.out.println("Usted tiene " + puntos + " puntos para repartir");
		System.out.println("Ingrese los puntos a repartir entre F I D:");
		Scanner sc = new Scanner(System.in);
		while (puntos == this.nivel / 10 + 1) {
			p_fuerza = sc.nextInt();
			p_inteligencia = sc.nextInt();
			p_destreza = sc.nextInt();
			if ((p_fuerza + p_inteligencia + p_destreza == puntos) && (this.fuerza + p_fuerza <= 200)
					&& (this.inteligencia + p_inteligencia <= 200) && (this.destreza + p_destreza <= 200)) {
				this.fuerza += p_fuerza;
				this.inteligencia += p_inteligencia;
				this.destreza += p_destreza;
				puntos = 0;
			} else
				System.out.println("ASIGNE BIEN LOS PUNTOS F I D:");

		}
		sc.close();

	}

	public void subirNivel() {

		int aux = 0;
		while (this.experiencia >= Personaje.tabla_nivel[this.nivel] + aux) {
			aux += Personaje.tabla_nivel[this.nivel];
			this.nivel++;
			this.asignarPuntos();
		}
		this.experiencia -= aux;
	}

	public void ganarExperiencia(int exp) {
		experiencia += exp;
		if (experiencia >= Personaje.tabla_nivel[this.nivel])
			this.subirNivel();
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
		Humano h = new Humano(100, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1, 50);
		Orco o = new Orco(200, 100, 15, 20, 30, new Guerrero(0.2, 0.3, 1.5), new LinkedList<Item>(),
				new LinkedList<Item>(), 0, 1, 1, 50);

		ItemDeManos excalibur = new ItemDeManos(1, 10, "Excalibur", "Manos", 50, 0, 0, 0, 0, 10, 10, 10);
		ItemDeTorso cotaDeMalla = new ItemDeTorso(2, 10, "Cota de Malla", "Manos", 0, 20, 0, 0, 0, 10, 10, 10);

		h.equiparItem(excalibur);
		h.equiparItem(excalibur);

		System.out.println("Energia Humano:" + " " + h.getEnergia());
		System.out.println("Vida del Orco:" + " " + o.getSalud());

		// h.habilidadCasta1(o);
		h.atacar(o);

		System.out.println("Energia Humano:" + " " + h.getEnergia());
		System.out.println("Vida del Orco:" + " " + o.getSalud());

		Personaje.cargar_tabla_nivel();
		h.ganarExperiencia(50);
		System.out.println("Nivel: " + h.getNivel());
		System.out.println("Exp: " + h.getExperiencia());

	}

}
