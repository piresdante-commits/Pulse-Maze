package testdepulso2d;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Robot;

public class PanelJuego extends JPanel implements MouseMotionListener {
    int[][] mapa = Mapa.mapa1;
    int numeroMapa = 1;
    
    int tamañoCelda = 20;// Cada posición de la matriz ocupará un cuadrado de ? × ? píxeles.
    
    Jugador jugador = new Jugador();
    
    boolean perdio = false; // Evita que el juego detecte la misma derrota varias veces.

    public PanelJuego() {
        addMouseMotionListener(this); // Esta pendiente de de los movimientos de mouse.
    }

    public void posicionarCursor() {

    try {

        Robot robot = new Robot();

        int x = jugador.columna * tamañoCelda + 10;
        int y = jugador.fila * tamañoCelda + 10;

        robot.mouseMove(
            getLocationOnScreen().x + x,
            getLocationOnScreen().y + y
        );

    } catch (Exception e) {

        System.out.println("No se pudo posicionar el cursor.");

    }
}
    
    public void cambiarMapa() {
        perdio = false; 
        
        numeroMapa++; // Esto aumenta la variable en uno (cambia el mapa).

        if (numeroMapa > 3) {
            numeroMapa = 1;
        }

        if (numeroMapa == 1) {
            mapa = Mapa.mapa1;
        }
            
            jugador.fila = Mapa.filaInicio1;
            jugador.columna = Mapa.columnaInicio1;
        
        if (numeroMapa == 2) {
            mapa = Mapa.mapa2;
        }

            jugador.fila = Mapa.filaInicio2;
            jugador.columna = Mapa.columnaInicio2;
        
        if (numeroMapa == 3) {
            mapa = Mapa.mapa3;
        }
            
            jugador.fila = Mapa.filaInicio3;
            jugador.columna = Mapa.columnaInicio3;
        
        repaint(); // Vuelve a dibujar el panel.
        
        posicionarCursor(); // posiciona el cursor sobre el checkpoint de cada mapa cada vez que cambian.
    }

    @Override
    protected void paintComponent(Graphics g) { // Graphics es una herramienta que Java nos proporciona para dibujar cosas en la ventana.

        super.paintComponent(g);

        for (int fila = 0; fila < mapa.length; fila++) { // Mapa.length nos dice cuántas filas tiene la matriz.

            for (int columna = 0; columna < mapa[fila].length; columna++) { // Recorre las columnas de cada fila.

                if (mapa[fila][columna] == 1) {
                    g.setColor(Color.BLACK);
                }

                if (mapa[fila][columna] == 0) {
                    g.setColor(Color.WHITE);
                }

                if (mapa[fila][columna] == 2) {
                    g.setColor(Color.GREEN);
                }

                if (mapa[fila][columna] == 3) {
                    g.setColor(Color.RED);
                }

                g.fillRect(  // Recibe: x, y, ancho y alto.
                    columna * tamañoCelda, // Determina dónde empieza horizontalmente.
                    fila * tamañoCelda, // Determina dónde empieza verticalmente.
                    tamañoCelda,
                    tamañoCelda
                );
            }
        }
        g.setColor(Color.BLUE);

        g.fillOval( // dibuja el circulo
            jugador.columna * tamañoCelda + 5,
            jugador.fila * tamañoCelda + 5,
        20,
        20
);
    }

    @Override
    public void mouseMoved(MouseEvent e) {  // Este método se ejecuta automáticamente cada vez que movemos el mouse sobre nuestro panel.

        int x = e.getX();
        int y = e.getY();

        int columna = x / tamañoCelda;
        int fila = y / tamañoCelda;

        
        if (fila >= 0 && fila < mapa.length &&
            columna >= 0 && columna < mapa[fila].length) {
            
        jugador.columna = columna;
        jugador.fila = fila;

        repaint();
        
        if (mapa[fila][columna] == 1 && !perdio) {
        perdio = true;
        System.out.println("PERDISTE - Tocaste una pared");
        cambiarMapa();
        }
        
        if (mapa[fila][columna] == 2) {

    System.out.println("¡GANASTE!");

        }
        if (mapa[fila][columna] == 3) {
            
            reproducirGrito();
            
    ImageIcon imagenOriginal = new ImageIcon(
    getClass().getResource("screamer ale.png")
);

ImageIcon imagen = new ImageIcon(
    imagenOriginal.getImage().getScaledInstance(
        1300,          //determina el hancho de la imagen
        650,          //deteermina el largo de la imagen
        java.awt.Image.SCALE_SMOOTH
    )
);

    JOptionPane.showOptionDialog(
    this,
    "",
    "¡¡¡SORPRESA!!!",
    JOptionPane.DEFAULT_OPTION,
    JOptionPane.PLAIN_MESSAGE,
    imagen,
    new Object[]{"Volver a jugar"},
    "Volver a jugar"
);

cambiarMapa();
}
        }
    }
    public void reproducirGrito() {   
    
        try {
        Clip clip = AudioSystem.getClip();

        clip.open(AudioSystem.getAudioInputStream(
            getClass().getResource("Sonidos-de-gritos.wav")
        ));

        clip.start();

    } catch (Exception e) {     //en caso de que el grito no se reproduzca

        System.out.println("No se pudo reproducir el sonido.");

    }
}

    @Override
    public void mouseDragged(MouseEvent e) {

    }
}