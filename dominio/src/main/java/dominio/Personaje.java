package dominio;

public class Personaje implements Peleable{
	
	int salud;
	int energia;
	int fuerza;
	int destreza;
	int inteligencia;
	Casta casta;
	Item [] itemsEquipados;
	Item [] itemsGuardados;
	int experiencia;
	int nivel;
	
	int defensa;
	int idPersonaje;
	
	public Personaje(String casta){
		
	}
	
	
	
	public Personaje(int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			Item[] itemsEquipados, Item[] itemsGuardados, int experiencia, int nivel, int idPersonaje,int defensa) {
		
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
		
		this.idPersonaje = idPersonaje;//agregue un Id para la base de datos (nose si se va a implementar asi)
		this.defensa =defensa;// creo que es mas comodo tener un atributo defensa que un metodo calcularPuntosDefensa
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



	public void atacar(Peleable atacado){
	atacado.serAtacado(this.getFuerza());
	}
	
	public void despuesDeTurno(){
		
	}
	
	public boolean puedeAtacar(){
		return true;
	}
	
	public int calcularPuntosDeAtaque(){
		return this.getFuerza(); // hago que el daño de un personaje sea igual a la fuerza que tiene, luego hay que modificarlo
		
	}
	
	/*public int calcularPuntosDeDefensa(){//creo que hay que tener el atributo de defensa propio
		return 0;
	}*/
	
	public boolean estaVivo(){
		return salud > 0;
	}
	
	public int serAtacado(int daño){
		daño -= this.getDefensa()*0.5;
		if(daño>0)
			{salud -= daño;
			return daño;
			}
		return 0;// no le hizo daño (la defensa fue mayor)
	}
	
	public void serDesernegizado(int daño){
		energia -= daño;
	}
	
	public void serCurado(int salud){
		this.salud += salud;
	}
	
	public void serEnergizado(){
		energia = 100;
	}
	
	public void desequiparItem(int item){
		
	}
	
	public void dropearItem(int  item){
		
	}
	public void salirDeAlianza(){
		
	}
	
	public void aliarme(Personaje aliado){
		
	}
	
	public void subirNivel(){
		
	}
	
	public void ganarExperiencia(int exp){
		experiencia += exp;
	}

	public void habilidad1(Peleable atacado)
	{
		if(this.getCasta() instanceof Guerrero)
		{
			if(this.getEnergia()>10)// habria que ver cuanta energia consume cada habilidad
			{
				
			Guerrero g1= (Guerrero)this.getCasta();
			g1.golpeDoble(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
		if(this.getCasta() instanceof Hechicero)
		{
			if(this.getEnergia()>10)
			{
			Hechicero h1= (Hechicero)this.getCasta();
			h1.curar(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
		if(this.getCasta() instanceof Asesino)
		{
			if(this.getEnergia()>10){
			Asesino a1= (Asesino)this.getCasta();
			a1.golpeCritico(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
	}
	
	
	public void habilidad2( Peleable atacado)
	{
		if(this.getCasta() instanceof Guerrero)
		{
			if(this.getEnergia()>10){
			Guerrero g1= (Guerrero)this.getCasta();
			g1.aumentarDefensa(this);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
		if(this.getCasta() instanceof Hechicero)
		{
			if(this.getEnergia()>10){
			Hechicero h1= (Hechicero)this.getCasta();
			h1.bolaDeFuego(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
		if(this.getCasta() instanceof Asesino)
		{
			if(this.getEnergia()>10){
			Asesino a1= (Asesino)this.getCasta();
			a1.perspicacia();
			this.setEnergia(this.getEnergia()-10);
			}
		}
	}
	
	public void habilidad3(Peleable atacado)
	{
		if(this.getCasta() instanceof Guerrero)
		{
			if(this.getEnergia()>10){
			Guerrero g1= (Guerrero)this.getCasta();
			g1.ignoraDefensa(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
		if(this.getCasta() instanceof Hechicero)
		{
			if(this.getEnergia()>10){
			Hechicero h1= (Hechicero)this.getCasta();
			h1.quitarEnergia(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
		
		if(this.getCasta() instanceof Asesino)
		{
			if(this.getEnergia()>10){
			Asesino a1= (Asesino)this.getCasta();
			a1.robar(this, atacado);
			this.setEnergia(this.getEnergia()-10);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Humano h = new Humano(100,100,15,20,30,new Guerrero(0.2,0.3,1.5),null,null,0,1,1,50);
		Orco o = new Orco(200,100,15,20,30,new Guerrero(0.2,0.3,1.5),null,null,0,1,1,50);
		
		System.out.println("Energia Humano:"+" "+h.getEnergia());
		System.out.println("Vida del Orco:"+" "+o.getSalud());
		
		//h.habilidad1(o);
		h.atacar(o);// esta bien que no le haga daño, ya que la defensa del orco es mas fuerte que la fuerza del humano
		
		System.out.println("Energia Humano:"+" "+h.getEnergia());
		System.out.println("Vida del Orco:"+" "+o.getSalud());
		
	}
	
}
