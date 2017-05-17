package dominio;

/** Peleable es una interface utilizada en las clases NonPlayableCharacter y Personaje*/
public interface Peleable {
  
  /** El siguiente metodo permite al enemigo atacar al personaje */
  int serAtacado(int dano);
  
  /** Este metodo devuelve la salud de la clase que implemente la interface Peleable*/
  int getSalud();
  
  /** Este metodo define lo que debe realizar la clase que implemente la interface Peleable*/
  void despuesDeTurno();
  
  /** Este metodo define la forma en la que la clase que implemente la interface Peleable tiene que atacar*/
  int atacar(Peleable atacado);
  
  /** Este metodo define la experiencia que otorga la clase que implemente la interface Peleable*/
  int otorgarExp();
  
  /** Este metodo devuelve el ataque de la clase que implemente la interface Peleable*/
  int getAtaque();
  
  /** Este metodo sirve para definir el ataque de la clase que implemente la interface Peleable*/
  void setAtaque(int ataque);
  
  /** Este metodo booleano devuelve si la clase esta viva*/
  boolean estaVivo();
  
  /** Este metodo devuelve el nombre de la clase que implemente la interface Peleable*/
  String getNombre();
}
