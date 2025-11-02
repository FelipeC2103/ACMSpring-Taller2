**Segundo Punto -  Taller2 Java Spring ACM**

Funcionalidad:

La aplicación permite obtener información de un Pokémon a través de dos endpoints:

### 1. `http://localhost:8080/pokemon/[NombreDelPokemon]`
Devuelve **toda la información principal** del Pokémon:
- ID  
- Nombre  
- Altura  
- Peso  
- Lista completa de habilidades

### 2. (Reto) `http://localhost:8080/pokemon/custom/[NombreDelPokemon]`
Se configura la respuesta con una clase llamada PokemonDto, para que solo devuelva los campos:

- Nombre
- Peso
- Lista de nombres de habilidades
