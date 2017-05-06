package dominio;

import java.io.Serializable;

/**
    La clase "Personaje" es la que se encargara de administrar los
    personajes de cada usuario, administrando todos sus atributos
    y las acciones que estos mismos realizan. 
*/
public abstract class Personaje implements Peleable, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static final int TAMANO_ARRAY_NIVELES = 101;
  private static final int SALTO_EXPERIENCIA_ENTRE_NIVELES = 50;
  private static final int FUERZA_BASE = 10;
  private static final int DESTREZA_BASE = 10;
  private static final int INTELIGENCIA_BASE = 10;
  private static final int BONUS_POR_CASTA = 5;
  private static final int TOPE_SALUD = 100;
  private static final int TOPE_ENERGIA = 100;
      
  protected int salud;
  protected int energia;
  protected int defensa;
  protected int ataque;
  protected int magia;

  protected String nombre;
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

  /** El siguiente método retorna las habilidades de raza que posee el personaje actual */
  public String[] getHabilidadesRaza() {
    return habilidadesRaza;
  }
  
  /** El siguiente método retorna las habilidades de casta que posee el personaje actual */
  public String[] getHabilidadesCasta() {
    return casta.getHabilidadesCasta();
  }
  
  /** El siguiente método carga la el array de niveles con las primeras dos posiciones
   * en cero y las siguientes 98 aumenta en 50 la al valor de la posicion anterior
   * */
  public static void cargarTablaNivel() {
    Personaje.tablaDeNiveles = new int[TAMANO_ARRAY_NIVELES];
    Personaje.tablaDeNiveles[0] = 0;
    Personaje.tablaDeNiveles[1] = 0;
    for (int i = 2; i < TAMANO_ARRAY_NIVELES; i++) {
      Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + SALTO_EXPERIENCIA_ENTRE_NIVELES;
    }
  }

  /** 
   * Constructor parametrizado
 */
  public Personaje(final String nombre,final Casta casta,final int id) {
    this.nombre = nombre;
    this.casta = casta;
    this.idPersonaje = id;
    experiencia = 0;
    nivel = 1;
    fuerza = FUERZA_BASE;
    inteligencia = INTELIGENCIA_BASE;
    destreza = DESTREZA_BASE;
    if (casta instanceof Guerrero) {
      fuerza += BONUS_POR_CASTA;
    }
    if (casta instanceof Hechicero) {
      inteligencia += BONUS_POR_CASTA;
    }
    if (casta instanceof Asesino) {
      destreza += BONUS_POR_CASTA;
    }

    x = 0;
    y = 0;
    saludTope = TOPE_SALUD;
    energiaTope = TOPE_ENERGIA;

    ataque = this.calcularPuntosDeAtaque();
    defensa = this.calcularPuntosDeDefensa();
    magia = this.calcularPuntosDeMagia();

  }

  /** 
   * Constructor parametrizado en donde se pasan los states
 */
  public Personaje(final String nombre, final int salud, final int energia,
      final int fuerza, final int destreza, final int inteligencia,final Casta casta,
      final int experiencia, final int nivel, final int idPersonaje) {

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
  public void setNombreRaza(final String nombreRaza) {
    this.nombreRaza = nombreRaza;
  }
  
  /** El siguiente metodo retorna el mombre del personaje */
  public String getNombre() {
    return nombre;
  }
  
  /** El siguiente metodo establece el mombre del personaje */
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  /** El siguiente metodo retorna el nivel de ataque del personaje */
  public int getAtaque() {
    return ataque;
  }
  
  /** El siguiente metodo establece el nivel de ataquea del personaje */
  public void setAtaque(final int ataque) {
    this.ataque = ataque;
  }
  
  /** El siguiente metodo retorna el nivel de magia del personaje */
  public int getMagia() {
    return magia;
  }
  
  /** El siguiente metodo establece el nivel de magia del personaje */
  public void setMagia(final int magia) {
    this.magia = magia;
  }
  
  /** El siguiente metodo retorna el tipo de alianza a la que pertenece el personaje */
  public Alianza getClan() {
    return clan;
  }
  
  /** El siguiente metodo establece el tipo de alianza a la que pertenece el personaje */ 
  public void setClan(final Alianza clan) {
    this.clan = clan;
    clan.anadirPersonaje(this);
  }
  
  /** El siguiente metodo establece el nivel de salud del personaje */
  public int getSalud() {
    return salud;
  }
  
  /** El siguiente metodo establece el nivel de salud del personaje */
  public void setSalud(final int salud) {
    this.salud = salud;
  }
  
  /** El siguiente metodo retorna el nivel de energa del personaje */
  public int getEnergia() {
    return energia;
  }
  
   /** El siguiente metodo establece el nivel de energa del personaje */
  public void setEnergia(final int energia) {
    this.energia = energia; 
  }
  
  /** El siguiente metodo retorna el nivel de fuerza del personaje */
  public int getFuerza() {
    return fuerza;
  }
  
  /** El siguiente metodo establece el nivel de fuerza del personaje */
  public void setFuerza(final int fuerza) {
    this.fuerza = fuerza;
  }
  
  /** El siguiente metodo retorna el nivel de destreza del personaje */
  public int getDestreza() {
    return destreza;
  }
  
  /** El siguiente metodo establece el nivel de destreza del personaje */
  public void setDestreza(final int destreza) {
    this.destreza = destreza;
  }
  
  /** El siguiente metodo retorna el nivel de inteligencia del personaje */
  public int getInteligencia() {
    return inteligencia;
  }
  
  /** El siguiente metodo establece el nivel de inteligencia del personaje */
  public void setInteligencia(final int inteligencia) {
    this.inteligencia = inteligencia;
  }
  
  /** El siguiente metodo retorna el tipo de casta a la que pertenece el personaje */
  public Casta getCasta() {
    return casta;
  }
  
  /** El siguiente metodo establece el tipo de casta a la que pertenece el personaje */
  public void setCasta(final Casta casta) {
    this.casta = casta; 
  }
  
  /** El siguiente metodo retorna el nivel de experiencia del personaje */
  public int getExperiencia() {
    return experiencia;
  }
  
  /** El siguiente metodo establece  el nivel de experiencia del personaje */
  public void setExperiencia(final int experiencia) {
    this.experiencia = experiencia;
  }
  
  /** El siguiente metodo retorna el nivel en el que se encuentra el personaje */
  public int getNivel() {
    return nivel;
  }
  
  /** El siguiente metodo establece el nivel donde se encuentra el personaje */
  public void setNivel(final int nivel) {
    this.nivel = nivel;
  }
  
  /** El siguiente metodo retorna el id del personaje */
  public int getIdPersonaje() {
    return idPersonaje;
  }
  
  /** El siguiente metodo establece el id del personaje */
  public void setIdPersonaje(final int idPersonaje) {
    this.idPersonaje = idPersonaje;
  }
  
  /** El siguiente metodo retorna el nivel de defensa del personaje */
  public int getDefensa() {
    return defensa;
  }
  
  /** El siguiente metodo esablece el nivel de defensa del personaje */
  public void setDefensa(final int defensa) {
    this.defensa = defensa;
  }
  
  /** El siguiente metodo retorna el nivel máximo de salud que puede tener el personaje */
  public int getSaludTope() {
    return saludTope;
  }
  
  /** El siguiente metodo establece el nivel máximo de salud que puede tener el personaje */
  public void setSaludTope(final int saludTope) {
    this.saludTope = saludTope;
  }
  
  /** El siguiente metodo retorna el nivel máximo de energia que puede tener el personaje */
  public int getEnergiaTope() {
    return energiaTope;
  }
  
  /** El siguiente metodo establece el nivel máximo de energia que puede tener el personaje */
  public void setEnergiaTope(final int energiaTope) {
    this.energiaTope = energiaTope;
  }
  
  /** El siguiente metodo permite al personaje atacar  a un enemigo sollo si cuenta con el nivel
     * de salud distinto de cero
     * */
  public int atacar(final Peleable atacado) {
    if (salud == 0) {
      return 0;
    }
                                
    if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
      return atacado.serAtacado(this.golpe_critico());
    } else {
      return atacado.serAtacado(this.ataque);
    }

    //return 0;
  }
  
  /** El siguiente método permite al personaje dar un golpe crítico al enemigo */
  public int golpe_critico() {
    return (int) (this.ataque * this.getCasta().getDanoCritico());
  }

  /** El siguiente define lo que tiene que realizar el personaje despues del turno*/
  public void despuesDeTurno() {

  }
  
  /** El siguiente metodo autoriza al personaje a poder atacar si cuenta con 
    * la energia suficiente
    * */
  public boolean puedeAtacar() {
    return energia > 10;
  }

  /** El siguiente metodo calcula los puntos de ataque siendo éste 3/2 de la fuerza
   * */
  public int calcularPuntosDeAtaque() {
    return (int) (this.getFuerza() * 1.5);
  }

  /** El siguiente metodo calcula los puntos de defenza siendo este el mismo
   *  valor de la destreza
   * */
  public int calcularPuntosDeDefensa() {
    return (int) (this.getDestreza());
  }

  /** El siguiente metodo calcula los puntos de magia siendo éste 3/2 de la inteligencia
   * */
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

  /** El siguiente asigna al ataque, defensa y magia los valores calculados */
  public void modificarAtributos() {
    this.ataque = this.calcularPuntosDeAtaque();
    this.defensa = this.calcularPuntosDeDefensa();
    this.magia = this.calcularPuntosDeMagia();
  }
  
  /** El siguiente metodo permite saber si el personaje esta con vida */
  public boolean estaVivo() {
    return salud > 0;
  }
  
  /** El siguiente metodo permite al enemigo atacar al personaje */
  public int serAtacado(int dano) {
    if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDano()) {
      dano -= this.defensa;
      if (dano > 0) {
        if (salud <= dano) {
          dano = salud;
          salud = 0;
        } else {
          salud -= dano;
        }
        return dano;
      }
      return 0;
    }
    return 0;
  }

  /**
   * El metodo "serRobadoSalud" se encarga de evaluar la cantidad
   * de vida que, en base al dano recibido, el atacante va a robar.
*/
  public int serRobadoSalud(int dano) {
    dano -= this.defensa;
    if (dano <= 0) {
      return 0;
    }
    if ((salud - dano) >= 0) {
      salud -= dano;
    } else {
      dano = salud;
      salud = 0;
    }
    return dano;
  }

  /**
   * metodo que calcula la energia despues de recibir daño
*/
  public int serDesernegizado(int dano) {
    dano -= this.defensa;
    if (dano <= 0) {
      return 0;
    }
    if ((energia - dano) >= 0) {
      energia -= dano;
    } else {
      dano = energia;
      energia = 0;
    }
    return dano;
  }

  /**
   * El metodo "serCurado" se encarga de evaluar la cantidad de 
   * vida que el personaje se va a curar sin sobrepasar el tope
   * de salud que un personaje puede tener. 
*/
  public void serCurado(final int salud) {
    if ((this.salud + salud) <= this.saludTope) {
      this.salud += salud;
    } else {
      this.salud = this.saludTope;
    }
  }
  
  /** El siguiente metodo permite cargar energia al personaje  */
  public void serEnergizado(final int energia) {
    if ((this.energia + energia) <= this.energiaTope) {
      this.energia += energia;
    } else {
      this.energia = this.energiaTope;
    }
  }
  
  /** El siguiente metodo permite al personaje crear una alianza */
  public void crearAlianza(final String nombreAlianza) {
    this.clan = new Alianza(nombreAlianza);
    this.clan.anadirPersonaje(this);
  }
  
  /** El siguiente metodo permite al personaje salir de la alianza en la que 
    * se encuentra
    */
  public void salirDeAlianza() {
    if (this.clan != null) {
      this.clan.eliminarPersonaje(this);
      this.clan = null;
    }
  }
  
  /** El siguiente metodo permite al personaje agregar un nuevo miembro a su alianza*/
  public boolean aliar(final Personaje nuevoAliado) {
    if (this.clan == null) {
      Alianza a = new Alianza("Alianza 1");
      this.clan = a;
      a.anadirPersonaje(this);
    }

    if (nuevoAliado.clan == null) {
      nuevoAliado.clan = this.clan;
      this.clan.anadirPersonaje(nuevoAliado);
      return true;
    } else {
      return false;
    }
  }

  /** metodo que actualiza los states sin que ests superen el tope*/
  public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
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

  /** metodo que controla lo sucedido cuando se sube el nivel, controlando
   * que no se exceda de 100 y que se asignen los nuevos atributos*/
  public void subirNivel() {

    int acumuladorExperiencia = 0;
    if (this.nivel == 100) {
      return;
    }
    while (this.nivel != 100 
           && (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]
           + acumuladorExperiencia)) {
      acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
      this.nivel++;
      this.modificarAtributos();
      this.saludTope += 25;
      this.energiaTope += 20;
    }
    this.experiencia -= acumuladorExperiencia;
  }

  /** metodo que asigna la experiencia segun la tabla de niveles*/
  public boolean ganarExperiencia(final int exp) {
    this.experiencia += exp;

    if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
      subirNivel();
      return true;
    }
    return false;
  }

  /** metodo que otorga la experiencia*/
  public int otorgarExp() {
    return this.nivel * 40;
  }

  /** sobrecarga de clone para clonar un Personaje*/
  @Override
    protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  /** calcula la distancia entre dos personajes*/
  public double distanciaCon(final Personaje p) {
    return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
  }

  /** habilidad 1 que se sobrecarga segun la casta*/
  public boolean habilidadCasta1(final Peleable atacado) {
    return this.getCasta().habilidad1(this, atacado);
  }

  /** habilidad 2 que se sobrecarga segun la casta*/
  public boolean habilidadCasta2(final Peleable atacado) {
    return this.getCasta().habilidad2(this, atacado);
  }

  /** habilidad 3 que se sobrecarga segun la casta*/
  public boolean habilidadCasta3(final Peleable atacado) {
    return this.getCasta().habilidad3(this, atacado);
  }

  /** habilidad 1 que se sobrecarga segun la raza*/
  public abstract boolean habilidadRaza1(final Peleable atacado);

  /** habilidad 2 que se sobrecarga segun la raza*/
  public abstract boolean habilidadRaza2(final Peleable atacado);
}
