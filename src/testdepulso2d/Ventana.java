package testdepulso2d;
import javax.swing.JFrame;
public class Ventana extends JFrame {  //Significa que nuestra clase Ventana hereda las características de JFrame.
    public Ventana() {

        setTitle("Test de Pulso 2D"); //Le ponemos un nombre a la ventana.
        setSize(800, 600); //Tamaño de la ventana.

        setLocationRelativeTo(null);// centra la pantalla.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Esto hace que cuando apretemos la X, se cierre el programa.

        setResizable(false); //Esto evita que el usuario agrande o achique la ventana. (seguramente se saque)

        setVisible(true);
        add(new PanelJuego());
    }
}

