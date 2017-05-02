package dominio;

import java.io.Serializable;

/**
	La clase "Personaje" es la que se encargara de administrar los 
	personajes de cada usuario, administrando todos sus atributos 
	y las acciones que estos mismos realizan. 
*/

public abstract class Personaje implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza
	protected int ataque;// depende de la fuerza
	protected int magia;// depende de la inteligencia

	protected String nombre;// hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;
	
	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int[] tablaDeNiveles;

	protected String[] habilidadesRaza;

	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}
    /** El siguiente método retorna las habilidades que posee el personaje actual */
	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++) {
      Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
    }
	}

	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero) {
      fuerza += 5;
    }
		if (casta instanceof Hechicero) {
      inteligencia += 5;
    }
		if (casta instanceof Asesino) {
      destreza += 5;
    }

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}
	/** El siguiente metodo retorna el mombre de la raza del personaje */
	public String getNombreRaza() {
		return nombreRaza;
	}
	/** El siguiente metodo establece el mombre de la raza del personaje */
	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}
	/** El siguiente metodo retorna el mombre del personaje */
	public String getNombre() {
		return nombre;
	}
	/** El siguiente metodo establece el mombre del personaje */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/** El siguiente metodo retorna el nivel de ataque del personaje */
	public int getAtaque() {
		return ataque;
	}
	/** El siguiente metodo establece el nivel de ataquea del personaje */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	/** El siguiente metodo retorna el nivel de magia del personaje */
	public int getMagia() {
		return magia;
	}
	/** El siguiente metodo establece el nivel de magia del personaje */
	public void setMagia(int magia) {
		this.magia = magia;
	}
	/** El siguiente metodo retorna el tipo de alianza a la que pertenece el personaje */
	public Alianza getClan() {
		return clan;
	}
	/** El siguiente metodo establece el tipo de alianza a la que pertenece el personaje */
	public void setClan(Alianza clan) {
		this.clan = clan;
		clan.añadirPersonaje(this);
	}
	/** El siguiente metodo establece el nivel de salud del personaje */
	public int getSalud() {
		return salud;
	}
	/** El siguiente metodo establece el nivel de salud del personaje */
	public void setSalud(int salud) {
		this.salud = salud;
	}
	/** El siguiente metodo retorna el nivel de energa del personaje */
	public int getEnergia() {
		return energia;
	}
	/** El siguiente metodo establece el nivel de energa del personaje */
	public void setEnergia(int energia) {
		
		
		this.energia = energia;
	}
	/** El siguiente metodo retorna el nivel de fuerza del personaje */	
	public int getFuerza() {
		return fuerza;
	}
	/** El siguiente metodo establece el nivel de fuerza del personaje */
	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	/** El siguiente metodo retorna el nivel de destreza del personaje */
	public int getDestreza() {
		return destreza;
	}
	/** El siguiente metodo establece el nivel de destreza del personaje */
	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}
	/** El siguiente metodo retorna el nivel de inteligencia del personaje */
	public int getInteligencia() {
		return inteligencia;
	}
	/** El siguiente metodo establece el nivel de inteligencia del personaje */
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	/** El siguiente metodo retorna el tipo de casta a la que pertenece el personaje */
	public Casta getCasta() {
		return casta;
	}
	/** El siguiente metodo establece el tipo de casta a la que pertenece el personaje */
	public void setCasta(Casta casta) {
		this.casta = casta;
	}
	/** El siguiente metodo retorna el nivel de experiencia del personaje */
	public int getExperiencia() {
		return experiencia;
	}
	/** El siguiente metodo establece  el nivel de experiencia del personaje */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	/** El siguiente metodo retorna el nivel en el que se encuentra el personaje */
	public int getNivel() {
		return nivel;
	}
	/** El siguiente metodo establece el nivel donde se encuentra el personaje */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/** El siguiente metodo retorna el id del personaje */
	public int getIdPersonaje() {
		return idPersonaje;
	}
	/** El siguiente metodo establece el id del personaje */
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	/** El siguiente metodo retorna el nivel de defensa del personaje */
	public int getDefensa() {
		return defensa;
	}
	/** El siguiente metodo esablece el nivel de defensa del personaje */
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	/** El siguiente metodo retorna el nivel máximo de salud que puede tener el personaje */
	public int getSaludTope() {
		return saludTope;
	}
	/** El siguiente metodo establece el nivel máximo de salud que puede tener el personaje */
	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}
	/** El siguiente metodo retorna el nivel máximo de energia que puede tener el personaje */
	public int getEnergiaTope() {
		return energiaTope;
	}
	/** El siguiente metodo establece el nivel máximo de energia que puede tener el personaje */
	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}
	/** El siguiente metodo permite al personaje atacar  a un enemigo sollo si cuenta con el nivel
	 * de salud distinto de cero
	 * */
	public int atacar(Peleable atacado) {
		if (salud == 0) {
      return 0;
    }
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}
	/** El siguiente método permite al personaje dar un golpe crítico al enemigo */
	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDañoCritico());
	}

	public void despuesDeTurno() {

	}
	/** El siguiente metodo autoriza al personaje a poder atacar si cuenta con 
	 * la energia suficiente
	 * */
	public boolean puedeAtacar() {
		return energia > 10;
	}
	
	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}
	/** El siguiente metodo recarga el nivel de salud del personaje al máximo */
	public void restablecerSalud() {
		this.salud = this.saludTope;
	}
	/** El siguiente metodo recarga el nivel de energía del personaje al máximo */
	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}
	/** El siguiente metodo permite saber si el personaje esta con vida */
	public boolean estaVivo() {
		return salud > 0;
	}
	/** El siguiente metodo permite al enemigo atacarpersonaje */
	public int serAtacado(int daño) {
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDaño()) {
			daño -= this.defensa;
			if (daño > 0) {
				if (salud <= daño) {
					daño = salud;
					salud = 0;
				} else {
					salud -= daño;
				}
				return daño;
			}
			return 0;
		}
		return 0;
	}

/**
	El metodo "serRobadoSalud" se encarga de evaluar la cantidad
	de vida que, en base al daño recibido, el atacante va a robar.
*/
	public int serRobadoSalud(int daño) {
		daño -= this.defensa;
		if (daño <= 0) {
      return 0;
    }
		if ((salud - daño) >= 0) {
      salud -= daño;
    } else {
			daño = salud;// le queda menos salud que el daño inflingido
			salud = 0;
		}
		return daño;
	}

	public int serDesernegizado(int daño) {
		daño -= this.defensa;
		if (daño <= 0) {
      return 0;
    }
		if ((energia - daño) >= 0) {
      energia -= daño;
    } else {
			daño = energia;// le queda menos energia que el daño inflingido
			energia = 0;
		}
		return daño;
	}

/**
	El metodo "serCurado" se encarga de evaluar la cantidad de 
	vida que el personaje se va a curar sin sobrepasar el tope
	de salud que un personaje puede tener. 
*/
	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope) {
      this.salud += salud;
    } else {
      this.salud = this.saludTope;
    }
	}
	/** El siguiente metodo permite cargar energia al personaje  */
	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
      this.energia += energia;
    } else {
      this.energia = this.energiaTope;
    }
	}
	/** El siguiente metodo permite al personaje crear una alianza */
	public void crearAlianza(String nombre_alianza) {
		this.clan = new Alianza(nombre_alianza);
		this.clan.añadirPersonaje(this);
	}
	/** El siguiente metodo permite al personaje salir de la alianza en la que 
	 * se encuentra
	 *  */
	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}
	/** El siguiente metodo permite al personaje agregar un nuevo miembro a su alianza*/
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
		} else {
      return false;
    }
	}

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200) {
      this.fuerza += fuerza;
    }
		if (this.destreza + destreza <= 200) {
      this.destreza += destreza;
    }
		if (this.inteligencia + inteligencia <= 200) {
      this.inteligencia += inteligencia;
    }
		this.modificarAtributos();
	}

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public boolean ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
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
}
