package dominio;

public abstract class  Casta {
protected double probabilidadGolpeCritico;
protected double probabilidadEvitarDaño;
protected double dañoCritico; 


public Casta (){
	this.probabilidadGolpeCritico=0.2;
	this.probabilidadEvitarDaño=0.2;
	this.dañoCritico=1.5;
}

public Casta(double prob_crit,double evasion,double daño_crit){
	this.probabilidadGolpeCritico=prob_crit;
	this.probabilidadEvitarDaño=evasion;
	this.dañoCritico=daño_crit;
}

public abstract boolean habilidad1 (Personaje caster,Peleable atacado);
public abstract boolean habilidad2 (Personaje caster,Peleable atacado);
public abstract boolean habilidad3 (Personaje caster,Peleable atacado);

public double getProbabilidadGolpeCritico() {
	return probabilidadGolpeCritico;
}
public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
	this.probabilidadGolpeCritico = probabilidadGolpeCritico;
}
public double getProbabilidadEvitarDaño() {
	return probabilidadEvitarDaño;
}
public void setProbabilidadEvitarDaño(double probabilidadEvitarDaño) {
	this.probabilidadEvitarDaño = probabilidadEvitarDaño;
}
public double getDañoCritico() {
	return dañoCritico;
}
public void setDañoCritico(double dañoCritico) {
	this.dañoCritico = dañoCritico;
}


}
