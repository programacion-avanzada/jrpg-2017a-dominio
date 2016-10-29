# Historias de Usuario y Criterios de aceptacion

### Como jugador, quiero crear mi personaje, editando sus caracteristicas principales (como raza y casta) para verme reflejado en mi avatar
* Dado un Personaje, cuando lo creo ,entonces elegire entre las Razas de Humano, Orco o Elfo
* Dado un Humano,Orco o Elfo,cuando lo creo, entonces me especializare en alguna de las siguientes castas: Guerrero,Hechicero o Asesino

### Como jugador,quiero ingresar a un mundo para adquirir experiencia, items y mejorar mis habilidades
* Dado un Personaje, cuando me muevo por un mundo, entonces no debo poder atravesar obstaculos

### Como jugador, quiero eliminar enemigos para aumentar mi experiencia
* Dado un Personaje y un NPC, cuando peleo contra este y lo elimino, entonces debo ganar una determinada experiencia 
* Dado 2 NPCs, cuando estos otrogan experiencia, entonces esta dependera del nivel del NPC,a mas nivel, mas experiencia
* Dado un Personaje y un enemigo, cuando peleo contra el y lo derroto, entonces debo ganar una determinada experiencia
* Dado un Personaje y un enemigo, cuando peleo contra el y me derrota, entonces no gano experiencia 

### Como jugador, quiero acumular experiencia para poder subir de nivel
* Dado un Personaje,cuando acumulo experiencia hasta una determinada cantidad, entonces subo de nivel
* Dado un Personaje nivel 100,cuando subo de nivel, entonces mantengo mi nivel 100 ya que es el maximo posible
* Dado un Personaje,cuando gano mas experiencia de la que necesito para los 2 proximos niveles, entonces subo 2 niveles

### Como jugador, quiero subir de nivel para poder asignar puntos adicionales a mis atributos
* Dado un Personaje, cuando gano experiencia y subo de nivel , entonces asignare puntos a mi atributo Fuerza 
* Dado un Personaje, cuando gano experiencia y subo de nivel ,entonces asignare puntos a mi atributo Inteligencia 
* Dado un Personaje, cuando gano experiencia y subo de nivel ,entonces asignare puntos a mi atributo Destreza
* Dado un Personaje, cuando gano experiencia y subo de nivel, entonces mi salud tope aumentara en 25 puntos
* Dado un Personaje, cuando gano experiencia y subo de nivel, entonces mi energia tope aumentara en 20 puntos
* Dado un Personaje, cuando asigno puntos a mis atributos Fuerza, Inteligencia y Destreza, entonces estos no superaran los 200 puntos cada uno

### Como jugador quiero aumentar mis atributos para poder manipular mejores items
* Dado un Personaje, cuando asigno puntos a mis atributos, entonces podre manipular items mas poderosos
* Dado un Personaje y un Item, cuando el Item requiera mas Fuerza de la que el Personaje tenga, entonces este no podra equiparselo
* Dado un Personaje y un Item, cuando el Item requiera mas Destreza de la que el Personaje tenga, entonces este no podra equiparselo
* Dado un Personaje y un Item, cuando el Item requiera mas Inteligencia de la que el Personaje tenga, entonces este no podra equiparselo

### Como jugador,quiero equipar items para poder potenciar mis atributos
* Dado un Personaje, cuando equipo un item que tenga bonificacion de daño,magia,defensa,salud o energia, entonces el ataque,magia,defensa,salud o energia (respectivamente) del Personaje sera mayor que el de antes 
* Dado un Personaje y un Item ya equipado, cuando el Personaje se desequipe el Item
,entonces el Personaje perdera la bonificacion del Item
* Dado un Personaje y 3 Items del tipo Manos, cuando el Personaje se equipe 2 de estos items, entonces no podra equiparse el tercero
* Dado un Personaje y 2 Items del tipo Torso,Cabeza,Pies o Accesorio, cuando el Personaje se equipe 1 de estos items, entonces no podra equiparse el segundo

### Como jugador, quiero disponer de atributos de Destreza, Fuerza e Inteligencia para afectar a mis puntos de ataque, defensa y magia
* Dado un Personaje, cuando aumento/decremento su Destreza, entonces su defensa debe aumentar/decrementar respectivamente
* Dado un Personaje, cuando aumento/decremento su Fuerza,entonces su ataque debe aumentar/decrementar respectivamente
* Dado un Personaje, cuando aumentar/decrementar su Inteligencia, entonces su magia debe aumentar/decrementar respectivamente

### Como jugador, quiero encontrarme con otros jugadores en el mismo mundo para aliarme a ellos o combatir contra ellos
* Dado 2 Personajes sin alianza, cuando se alian,entonces se forma una Alianza
* Dado un Personaje y un enemigo, cuando el Personaje ataca al enemigo,entonces éste pierde salud
* Dado un Personaje sin alianza y otro Personaje con alianza, cuando el segundo alia al primero, entonces este forma parte de la alianza del primero

### Como jugador, quiero aliarme con otro jugador para combatir junto a el y repartir la experiencia que recolectamos al pelear contra otros enemigos
* Dado un Personaje, cuando combato con mi batallon y ganamos experiencia, entonces esta se repartera en partes iguales entre los miembros del mismo

### Como jugador, quiero combatir contra otros jugadores y NPCs para obtener uno de sus items al derrotarlos
* Dado un Personaje y un enemigo, cuando peleo contra este y lo derroto, entonces obtendre uno de sus items
* Dado un Personaje y un NPC, cuando peleo contra este y lo derroto, entonces obtendre uno de sus items 
* Dado un Personaje y un enemigo, cuando pierdo contra el enemigo en una Batalla, entonces perdere un item
* Dado un Personaje y un NPC, cuando pierdo contra el NPC en una Batalla, entonces no perdere ningun item

### Como jugador, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo para poder traicionar a mis aliados
* Dado un Personaje,cuando dejo mi alianza, entonces podre unirme a otra nueva
* Dado 2 Personajes, cuando crean una alianza, entonces esta no se podra romper por lo menos hasta pasados los 30 segundos de su creacion

### Como jugador, quiero guardar items ademas de los que ya llevo equipados, para luego poder equiparmelos
* Dado un Personaje y un Item , cuando me lo guardo, entonces mi inventario crecera (en cantidad de Items guardados)

### Como jugador,quiero tener una probabilidad de golpe critico, para asi poder hacer un daño mayor que lo normal
* Dado un Personaje, cuando realizo un golpe critico, entonces el daño causado por este es 1.5 veces el daño normal

### Como jugador, quiero tener una probabilidad de evasion, para asi tener la oportunidad de no sufrir daño
* Dado un Personaje y un enemigo, cuando evado un ataque del enemigo, entonces mi salud no disminuira

### Como Asesino, quiero poder robarle a mis enemigos para asi obtener alguno de sus items
* Dado un Asesino y un enemigo, cuando utilizo mi habilidad de Robar contra mi enemigo y es efectiva, entonces este pierde un item y yo lo adquiero
* Dado un Asesino, cuando tengo 20 items guardados en mi mochila, entonces no puedo robarle a mis enemigos










 
