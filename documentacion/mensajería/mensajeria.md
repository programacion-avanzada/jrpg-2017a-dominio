# Mensajeria

## Inicio de sesion:
### Cliente envia al sevidor el usuario y contraseña
```sh
{"usuario":"user1234","contraseña":"pass1234"}
```
### Confirmacion o respuesta del servidor
```sh
{"respuesta":"true"}
```
## Creacion de personaje
### Servidor solicia al cliente crear el personaje
```sh
{"creacionpj":"true"}
```
### Cliente le envia los datos del personaje creado al servidor
```sh
{"raza":"Humano","casta":"Guerrero","fuerza":2,"destreza":1,"inteligencia":0}
```
## Dentro de la partida
### Cliente le envia el mapa seleccionado al servidor
```sh
{"mapa":"LaNocheOsucra"}
```
### Cliente envia posicion del personaje
```sh
{"x":10,"y":20}
```
### Servidor envia posicion de todos los personajes
```sh
{"personaje":"user1234","x":10,"y":20}
```
### Cliente envia desconexion del personaje del mapa
```sh
{"personaje":"user1234","desconexion":"true"}
```
## Manejo de ítems
### Cliente equipa un item
```sh
{"item":"EspadaMuyFilosa","nivel":2,"tipoaccion":"Equipar"}
```
### Cliente desequipa ítem
```sh
{"item":"EspadaMuyFilosa","nivel":2,"tipoaccion":"Desequipar"}
```
### Cliente guarda ítem
```sh
{"item":"EspadaMuyFilosa","nivel":2,"tipoaccion":"Guardar"}
```
### Cliente droppea ítem
```sh
{"item":"EspadaMuyFilosa","nivel":2,"tipoaccion":"Tirar"}
```

## Manejo de acciones del personaje
### Cliente envia click derecho
```sh
{"tipoaccion":"clickDerecho","x":15,"y":30}
```
### Servidor envia menu de opciones
```sh
{"tipoaccion":"menuOpciones","x":15,"y":30,"pjafectado":"user4321"}
```

## Manejo de alianzas
### Cliente se una a una alianza
```sh
{"tipoaccion":"crearAlianza","pjafectado":"user4321"}
```
### Servidor envia solicitud de alianza a cliente solicitado
```sh
{"tipoaccion":"crearAlianza","pjsolicitante":"user1234"}
```
### Cliente solicitado le envia respuesta la servidor
```sh
{"tipoaccion":"crearAlianza","respuesta":"true"}
```
## Manejo de peleas
### Cliente solicita pelear
```sh
{"tipoaccion":"pelear","pjafectado":"user4321"}
```
### Servidor envia escenario de batalla 
```sh
{"tipoaccion":"pelear"}
{"BatallonUno":[
    {"personaje":"user1234"},
    {"personaje":"user2345"},
    {"personaje":"user3456"}
]}
{"BatallonDos":[
    {"personaje":"user4321"},
    {"personaje":"user5432"},
    {"personaje":"user6543"}
]}
```
### Servidor habilita a cliente atacante
```sh
{"tipoaccion":"asignarTurno","batallon":"BatallonUno","personaje":"user1234"}
```
### El cliente envia el ataque 
```sh
{"tipoaccion":"ataque","personaje":"user4321","daño":30}
```
### Servidor envia ataque al cliente atacado
```sh
{"tipoaccion":"ataque","daño":30}
```
### Servidor envia los personajes a los clientes
```sh
{"personaje":"user1234","salud":85,"energia":60}
```



   