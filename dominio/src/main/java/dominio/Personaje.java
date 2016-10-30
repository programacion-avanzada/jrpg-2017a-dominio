package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public abstract class Personaje implements Peleable {

	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza y de los items
	protected int ataque;// depende de la fuerza y de los items
	protected int magia;// depende de la inteligencia y de los items

	protected String nombre;// hay que agregarlo a todos los constructores

	protected int x;
	protected int y;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected LinkedList<Item> itemsEquipados;
	protected LinkedList<Item> itemsGuardados;
	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;
	protected int itemManos = 0;
	protected Alianza clan = null;
	protected static int tablaDeNiveles[];

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}

	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		x = 0;
		y = 0;
		itemsEquipados = new LinkedList<Item>();
		itemsGuardados = new LinkedList<Item>();
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			fuerza += 5;
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

		saludTope = 50;
		energiaTope = 50;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			LinkedList<Item> itemsEquipados, LinkedList<Item> itemsGuardados, int experiencia, int nivel,
			int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		if(itemsEquipados!=null)
			this.itemsEquipados = itemsEquipados;
		else
			this.itemsEquipados = new LinkedList<Item>();
		if(itemsGuardados!=null)
			this.itemsGuardados = itemsGuardados;
		else
			this.itemsGuardados = new LinkedList<Item>();

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public int getPosicion_x() {
		return x;
	}

	public void setPosicion_x(int posicion_x) {
		this.x = posicion_x;
	}

	public int getPosicion_y() {
		return y;
	}

	public void setPosicion_y(int posicion_y) {
		this.y = posicion_y;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);//////////////////////
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

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	public int atacar(Peleable atacado) {
		Random rnd = new Random();
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (rnd.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				System.out.println("GOLPE CRITICO!");
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
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
			daño_items += it.next().bonoDaño;
		return (int) (this.getFuerza() * 1.5 + daño_items);
	}

	public int calcularPuntosDeDefensa() {
		int defensa_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			defensa_items += it.next().bonoDefensa;
		return (int) (defensa_items + this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		int magia_items = 0;
		Iterator<Item> it = this.itemsEquipados.iterator();
		while (it.hasNext())
			magia_items += it.next().bonoMagia;
		return (int) (this.getInteligencia() * 1.5 + magia_items);

	}

	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	/*
	 * public int calcularPuntosDeSalud() { int salud_items=0; Iterator<Item> it
	 * = this.itemsEquipados.iterator(); while (it.hasNext()) salud_items +=
	 * it.next().bono_salud;
	 * System.out.println("Salud del pj: "+this.getSalud()+" Salud del item"
	 * +salud_items); return (this.getSalud()+salud_items); } ////MAL
	 * IMPLEMENTADOSSSSSSSSSSSSSSSSSSSSSSSS
	 * 
	 * public int calcularPuntosDeEnergia() { int energia_items=0;
	 * Iterator<Item> it = this.itemsEquipados.iterator(); while (it.hasNext())
	 * energia_items += it.next().bono_energia;
	 * System.out.println("Energia del pj: "+this.getEnergia()
	 * +" Energia del item:"+energia_items); return
	 * (this.getEnergia()+energia_items); }
	 */ // MAL IMPLEMENTADOSSSSSSSSSSSSSSSSSSSSSSSS

	public void modificarAtributos() {
		// this.salud=this.calcularPuntosDeSalud();
		// this.energia=this.calcularPuntosDeEnergia();
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();

	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int serAtacado(int daño) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (salud <= daño) {
					daño = salud;
					salud = 0;
				} else {
					salud -= daño;
					return daño;
				}
			}
			return 0;
		}
		System.out.println("GOLPE EVADIDO!");
		return 0;
	}

	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((salud - daño) >= 0)
			salud -= daño;
		else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}

	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0)
			return 0;
		if ((energia - daño) >= 0)
			energia -= daño;
		else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;

	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	public boolean desequiparItem(Item i) { // lo puedo usar para desequipar un
											// item o para dropear directamente
		// un item equipado
		if (this.itemsEquipados.remove(i)) {
			if (i.getTipo() == "Manos")
				this.itemManos--;
			this.modificarAtributos();
			this.saludTope -= i.getBonoSalud();
			this.energiaTope -= i.getBonoEnergia();
			this.salud = this.saludTope;
			this.energia = this.energiaTope;
			return true;
		}
		return false;
	}

	public boolean dropearItemMochila(Item i) { 
		return this.itemsGuardados.remove(i);
	}

	public boolean guardarItem(Item i) {
		if (this.itemsGuardados.size() < 20) {
			this.itemsGuardados.add(i);
			return true;
		}
		return false;
	}

	public boolean equiparItem(Item i) {
		if (this.itemsEquipados.size() <= 6) {
			if (this.puedeEquipar(i)) {
				this.itemsEquipados.add(i);
				this.modificarAtributos();
				this.saludTope += i.getBonoSalud();
				this.energiaTope += i.getBonoEnergia();
				return true;
			}

		}

		return false;
	}

	public boolean puedeEquipar(Item i) {
		if (this.fuerza < i.getFuerzaRequerida() || this.destreza < i.getDestrezaRequerida()
				|| this.inteligencia < i.getInteligenciaRequerida())
			return false;
		if (i.getTipo() == "Manos") {
			if (itemManos < 2) {
				itemManos++;
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

	public Item getEquipado(int i) {
		if (this.itemsEquipados.size() > i)
			return this.itemsEquipados.get(i);
		return null;
	}

	public Item getMochila(int i) {
		if (this.itemsGuardados.size() > i)
			return this.itemsGuardados.get(i);
		return null;
	}

	public Item otorgarItem() {
		if (this.getItemsEquipados().size() == 0 && this.getItemsGuardados().size() == 0)
			return null;
		Item aux;
		Random rnd = new Random();
		if (this.getItemsGuardados().size() > 0) {
			aux = this.getItemsGuardados().get(rnd.nextInt(this.itemsGuardados.size()));
			this.dropearItemMochila(aux);
			return aux;
		} else {
			aux = this.getItemsEquipados().get(rnd.nextInt(this.itemsEquipados.size()));
			this.desequiparItem(aux);
			return aux;
		}

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
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.añadirPersonaje(this);
		}

		if (nuevo_aliado.clan == null) {
			nuevo_aliado.clan = this.clan;
			this.clan.añadirPersonaje(nuevo_aliado);
			return true;
		} else
			System.out.println("NO SE PUEDE ALIAR YA QUE YA ESTA EN UNA ALIANZA");
		return false;
	}

	/*
	 * public void asignarPuntos() { int puntos = this.nivel / 10 + 1; int
	 * p_fuerza, p_inteligencia, p_destreza; System.out.println("Usted tiene " +
	 * puntos + " puntos para repartir");
	 * System.out.println("Ingrese los puntos a repartir entre F I D:"); Scanner
	 * sc = new Scanner(System.in); while (puntos == this.nivel / 10 + 1) {
	 * p_fuerza = sc.nextInt(); p_inteligencia = sc.nextInt(); p_destreza =
	 * sc.nextInt(); if ((p_fuerza + p_inteligencia + p_destreza == puntos) &&
	 * (this.fuerza + p_fuerza <= 200) && (this.inteligencia + p_inteligencia <=
	 * 200) && (this.destreza + p_destreza <= 200)) { this.fuerza += p_fuerza;
	 * this.inteligencia += p_inteligencia; this.destreza += p_destreza; puntos
	 * = 0; } else System.out.println("ASIGNE BIEN LOS PUNTOS F I D:");
	 * 
	 * } sc.close();
	 * 
	 * }
	 */

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			System.out.println("Ya ha alcanzado el maximo nivel!");
			return;
		}
		while (this.nivel != 100 && (this.experiencia >= Personaje.tablaDeNiveles[this.nivel+1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel+1];
			this.nivel++;
			// this.asignarPuntos();
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public void ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel])
			this.subirNivel();
	}

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);

	public int elegirOpcion() {
		String aux = "";
		aux += "1-Atacar\n";
		if (this.getCasta() instanceof Guerrero)
			aux += "2-Golpe Doble\n3-Aumentar Defensa\n4-Ignorar Defensa\n";
		if (this.getCasta() instanceof Hechicero)
			aux += "2-Bola de Fuego\n3-Curar\n4-Robar Energia y Salud\n";
		if (this.getCasta() instanceof Asesino)
			aux += "2-Golpe Critico\n3-Aumentar Evasion\n4-Robar\n";

		if (this instanceof Humano)
			aux += "5-Incentivar\n6-Golpe Fatal\n";
		if (this instanceof Elfo)
			aux += "5-Golpe Level\n6-Ataque Bosque\n";
		if (this instanceof Orco)
			aux += "5-Super Golpe\n6-Mordisco de Vida\n";
		System.out.println(aux);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();

	}

	public LinkedList<Personaje> armarBatallonPjs() {

		LinkedList<Personaje> batallon_amigo = new LinkedList();
		batallon_amigo.add(this);
		if (this.getClan() != null) {
			Iterator<Personaje> it = this.getClan().getAliados().iterator();
			Personaje aux;
			while (it.hasNext()) {
				aux = it.next();
				if (aux != this && aux.distanciaCon(this) <= 10)
					batallon_amigo.add(aux);
			}

		}
		return batallon_amigo;

	}
}
