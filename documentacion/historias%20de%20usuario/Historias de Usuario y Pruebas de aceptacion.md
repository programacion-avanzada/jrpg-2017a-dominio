# Historias de Usuario y Criterios de aceptacion

### Como jugador, quiero crear mi personaje, editando sus caracteristicas principales (como raza y casta) para verme reflejado en mi avatar
* Dado un Personaje, cuando lo creo ,elegire entre las Razas de Humano, Orco o Elfo
* Dado un Humano,Orco o Elfo,cuando lo creo, me especializare en alguna de las siguientes castas: Guerrero,Hechicero o Asesino
* Dado un Humano,Orco o Elfo, cuando invoco a mis skills de raza, estas deben ser distintas a las skills de las demas Razas
* Dado un Guerrero,Asesino o Hechicero, cuando invoco a mis skills de casta,  estas deben ser distintas a las skills de las demas Castas

### Como jugador,quiero ingresar a un mundo para adquirir experiencia, items y mejorar mis habilidades
* Dado un Personaje, cuando me muevo por un mundo,no debo poder atravesar obstaculos

### Como jugador, quiero eliminar enemigos para aumentar mi experiencia
* Dado un Personaje, cuando peleo contra NPCs y los elimino, debo ganar una determinada experiencia 
* La experiencia recibida al eliminar un NPC depende del nivel del mismo, a mas nivel, mas experiencia
* Dado un Personaje,cuando peleo contra otros Personajes y los derroto,debo ganar una determinada experiencia
* Dado un Personaje, no debo ganar experiencia si muero en combate

### Como jugador, quiero acumular experiencia para poder subir de nivel
* Dado un Personaje,cuando acumulo experiencia hasta una determinada cantidad, debo  subir de nivel
* Dado un Personaje, cuando subo de nivel, el proximo nivel debo necesitar mas experiencia de la que necesite para llegar a mi nivel actual
* Dado un Personaje,cuando subo de nivel,el maximo nivel posible alcanzado por el mismo es nivel 100

### Como jugador, quiero subir de nivel para poder asignar puntos adicionales a mis atributos
* Dado un Personaje, cuando subo de nivel ,debo poder asignarle puntos a mi atributo Fuerza 
* Dado un Personaje, cuando subo de nivel ,debo poder asignarle puntos a mi atributo Inteligencia 
* Dado un Personaje, cuando subo de nivel ,debo poder asignarle puntos a mi atributo Destreza
* Dado un Personaje, cuando asigno puntos a mis atributos Fuerza, Inteligencia, Destreza, estos no pueden superar los 200 puntos cada uno
* No debo poder quitar puntos a mis atributos una vez que ya han sido asignados

### Como jugador quiero aumentar mis atributos para poder manipular mejores items
* Dado un Personaje, cuando asigno puntos a mis atributos, debo poder manipular items mas poderosos
* No se debe poder equipar items que requieran mas Fuerza de la que un Personaje tenga
* No se debe poder equipar items que requieran mas Destreza de la que un Personaje tenga
* No se debe poder equipar items que requieran mas Inteligencia de la que un Personaje tenga

### Como jugador,quiero equipar items para poder potenciar mis atributos
* Dado un Personaje, cuando equipo un item que tenga bonificacion de daño,magia,defensa,salud o energia, el ataque,magia,defensa,salud o energia (respectivamente) del Personaje sera mayor que el de antes 
* No debo poder equipar mas de 2 items del tipo Manos
* No debo poder equipar mas de 1 item del tipo Torso,Pies,Cabeza y Accesorio
* Dado un Personaje, debo poder desequiparme items 

### Como jugador, quiero disponer de atributos de Destreza, Fuerza e Inteligencia para afectar a mis puntos de ataque, defensa y magia
* Dado un Personaje, cuando aumento/decremento su Destreza, su defensa debe aumentar/decrementar respectivamente
* Dado un Personaje, cuando aumento/decremento su Destreza, su probabilidad de critico debe aumentar/decrementar respectivamente
* Dado un Personaje, cuando aumento/decremento su Fuerza,su daño al atacar debe aumentar/decrementar respectivamente
* Dado un Personaje, cuando aumentar/decrementar su Inteligencia, su magia debe aumentar/decrementar respectivamente

### Como jugador, quiero encontrarme con otros jugadores en el mismo mundo para aliarme a ellos o combatir contra ellos
* Dado un Personaje, cuando me encuentro con otro Personaje, debo poder aliarme y formar una alianza
* Dado un Personaje,cuando me encuentro con otro Personaje, debo poder pelear con el en una Batalla
* No debo poder luchar contra Personajes de mi misma alianza
* No debo poder tenes mas de 1 alianza
* No debo poder aliar a otro Personaje que ya posea una alianza


### Como jugador, quiero aliarme con otro jugador para combatir junto a el y repartir la experiencia que recolectamos al pelear contra otros enemigos
* Dado un Personaje, cuando combato con mi alianza, la experiencia se dividira en partes iguales

### Como jugador, quiero combatir contra otros jugadores y NPCs para obtener uno de sus items al derrotarlos
* Dado un Personaje, cuando peleo contra otros Personajes y los derroto, debo obtener uno de sus items
* Dado un Personaje, cuando peleo contra NPCs y los derroto, debo obtener uno de sus items 
* Dado un Personaje, cuando pierdo contra otro Personaje en una Batalla, debo perder un item
* No debo poder perder mas de 1 item al ser derrotado en batalla
* No debo perder items si soy derrotado en batalla contra un NPC

### Como jugador, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo para poder traicionar a mis aliados
* Dado un Personaje,cuando dejo mi alianza, me puedo unir a otra nueva
* Las alianzas deben durar un tiempo minimo de 30 segundos desde que se forma la misma
* Las alianzas se deben poder conservar en el tiempo

### Como jugador, quiero guardar items ademas de los que ya llevo equipados, para luego poder equiparmelos
* Dado un Personaje, cuando no quiero tener mas un item, debo poder dropearlo
* Los items desechados deben ser destruidos
* Dado un Personaje, cuando tengo un item guardado, debo poder intercambiarlo con un item equipado y viceversa

### Como jugador,quiero tener una probabilidad de golpe critico, para asi poder hacer un daño mayor
* Dado un Personaje, cuando realizo un golpe critico, el daño causado por este es 1.5 veces el daño normal

### Como jugador, quiero tener una probabilidad de evasion, para asi tener la oportunidad de no sufrir daño
* Dado un Personaje, cuando evado un ataque, no debo recibir daño alguno
* La probabilidad de evasion debe tener un tope de 50%

### Como Asesino, quiero poder robarle a mis enemigos para asi obtener alguno de sus items
* Dado un Asesino, cuando utilizo mi habilidad de Robar y es efectiva, mi enemigo pierde un item y yo lo adquiero
* La probabilidad de exito del robo es de 0.2
* Dado un Asesino y un enemigo, cuando le robo a mi enemigo, este pierde un item y lo adquiero yo
* Dado un Asesino, cuando tengo 20 items guardados en mi mochila, no puedo robarle a mis enemigos










 
