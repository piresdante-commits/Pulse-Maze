Test de Pulso 2D (Pulse Maze)
Pulse maze un juego de laberinto en 2D inpirado en maze of fear, donde el jugador debe atravezar distintos caminos utilizando el mouse, sin tocar las paredes.

El juego cuenta con tres mapas distintos representados con matrices, cada uno con un diseño diferente. si el jugador toca una pared, el juego cambia automaticante a otro mapa y reinicia su posición en el punto de partida.

En los diferentes mapas dependiendo del camino el jugador puede llegar a encontrarse con el jumpscare y un sonido de un grito antes de reiniciar el pregreso.
Al llegar a la casilla verde (meta), se muesetra una pantalla de victoria con su propio sonido y animacion (GIF).

Mecánicas:
- MOVIMIENTO: El jugador se controla mediante el mouse; el cursor que "atado" a la posición del punto azul dentro de la ventana.

- PAREDES: Si el jugador toca una pared, el juego automatiucante cambia al siguente mapa.

- SCREAMER: En los diferentes mapas se encuentra una casilla que contiene el screamer (imagen+audio).

- META: Al llegar a la casilla verde del mapa, se muestra una pantalla de victoria (GIF+audio).

- MAPAS: Los tres laberintos entán representados con matrices dentro de la clase Mapa.java, sonde cada número representa un elemnto del mapa:
- 0: Camino libre.
- 1: Pared.
- 2: Meta/Victoria.
- 3: Screamer.

Tecnologias utlizadas:
- NetBeans 17 como entorno de desarrolo.
- Java(Swing/AWT para la interfaz grafica).
- javax.awt para colores, dibujo y control del cursor (robot).
- java.sound.sampled para la reproducción de audio.

Estructura del proyecto:
- Main.java: Punto de entrada del programa.
- Ventana.java: Contiene la lógica del juego. dibujado del mapa, detección de colisiones, cambi de mapas, pantalla de victoria y derrota.
- Mapa.java: Almacena las matrices de los tres laberintos y sus respectivos puntos de inicio.
- Jugador.java: Representa la posición del jugador dentro del mapa.

Autores:
- Pires Dante 
- Luases Meyer Mercedes
- Toledo Sofia 
