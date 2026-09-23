package testdepulso2d;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame {  //Significa que nuestra clase Ventana hereda las características de JFrame.
    public Ventana() {

        setTitle("Test de Pulso 2D"); //Le ponemos un nombre a la ventana.
        setSize(800, 650); //Tamaño de la ventana.

        setLocationRelativeTo(null);// centra la pantalla.

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Esto hace que cuando apretemos la X, se cierre el programa.

        setResizable(false); //Esto evita que el usuario agrande o achique la ventana. (seguramente se saque)
        
        mostrarMenu();     
        setVisible(true);        
    }
    public void mostrarMenu() {

        JPanel panelMenu = new JPanel();

        panelMenu.setBackground(Color.BLACK);   //color del fondo
        panelMenu.setLayout(null);

        // Título
        JLabel titulo = new JLabel("TEST DE PULSO 2D");

        titulo.setBounds(180, 60, 450, 50);   //posicion y tamaño del titulo

        titulo.setHorizontalAlignment(SwingConstants.CENTER);   //para alinear horizontalmente el texto dentro del espacio que ocupa titulo

        titulo.setFont(new Font("Arial", Font.BOLD, 30));   //fuente

        titulo.setForeground(new Color(0, 255, 255));  //color

        panelMenu.add(titulo);   //agrega el titulo

        // Botón jugar
        JButton botonJugar = new JButton("JUGAR");   //crea el boton

        botonJugar.setBounds(300, 180, 200, 45);

        botonJugar.setBackground(Color.BLACK);

        botonJugar.setForeground(new Color(0,255,255));

        botonJugar.setFocusPainted(false);   //para sacar el borde del texto del boton

        botonJugar.setFont(new Font("Arial", Font.BOLD, 18));

        panelMenu.add(botonJugar);

        // Botón cómo jugar
        JButton botonComoJugar = new JButton("¿CÓMO JUGAR?");

        botonComoJugar.setBounds(300, 260, 200, 45);

        botonComoJugar.setBackground(Color.BLACK);

        botonComoJugar.setForeground(new Color(0,255,255));

        botonComoJugar.setFocusPainted(false);

        botonComoJugar.setFont(new Font("Arial", Font.BOLD, 18));

        panelMenu.add(botonComoJugar);

        add(panelMenu);

        botonJugar.addActionListener(e -> {

            getContentPane().removeAll();  //saca el menu

            // Barra superior
            JPanel barraSuperior = new JPanel(new BorderLayout());
            barraSuperior.setBackground(Color.BLACK);
            barraSuperior.setPreferredSize(new Dimension(800, 30));

            JButton botonSalir = new JButton("SALIR DEL JUEGO");   //boton de salir

            botonSalir.setBackground(Color.BLACK);
            botonSalir.setForeground(new Color(0, 255, 255));
            botonSalir.setFocusPainted(false);
            botonSalir.setFont(new Font("Arial", Font.BOLD, 14));

            botonSalir.addActionListener(evento -> {
                System.exit(0);   //para cerrar el programa
            });

            barraSuperior.add(botonSalir, BorderLayout.EAST);  //boton de salir a la derecha de la barra

            PanelJuego panel = new PanelJuego();  //pone el juego

            add(barraSuperior, BorderLayout.NORTH);   //la barra superior

            add(panel, BorderLayout.CENTER);  //laberinto abajo

            //actualiza la ventana
            revalidate();
            repaint();

            panel.posicionarCursor();  //para acomodar el mouse
        });

        botonComoJugar.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "¿CÓMO JUGAR?\n\n"
                    + "Controlá el punto azul con el mouse.\n\n"
                    + "OBJETIVO:\n"
                    + "Llegar al punto verde sin tocar\n"
                    + "las paredes negras.\n\n"
                    + "Si tocás una pared perderás\n"
                    + "y cambiarás al siguiente mapa.\n\n"
                    + "Si llegás al punto verde\n"
                    + "¡GANASTE!",
                    "¿Cómo jugar?",
                    JOptionPane.INFORMATION_MESSAGE);

        });
    }
}


