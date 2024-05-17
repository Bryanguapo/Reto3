import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preguntas extends JFrame implements ActionListener, Runnable {
    // OBJETOS
    private Thread contador;
    
    private JLabel lblTitulo;
    private JLabel lblEnunciado;
    private JLabel lblContador;
    private JLabel lblPuntos;

    private JButton btnRespuesta1;
    private JButton btnRespuesta2;
    private JButton btnRespuesta3;
    private JButton btnRespuesta4;
    
    private JLabel lblImagenPregunta;
    private static ImageIcon img;
    
    JPanel p1, p2, p3;
    

    String correcta;
    int tiempo = 0;
    int puntos = 0;
    
    String dificultad;
    int tiempoescogido;

    // CONSTRUCTORES
    public Preguntas(String d, int t) {

        dificultad = d;
        tiempoescogido = t;

        // Configuración básica de la ventana
        setTitle("Preguntas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        
        // Crear paneles
        p1 = new JPanel(new GridLayout(2,1));
        p2 = new JPanel(new GridLayout(3,2));
        p3 = new JPanel();
        
        p1.setBackground(Color.decode("#4CAF50"));
        p2.setBackground(Color.decode("#f0f0f0"));
        
        // Crear el titulo de texto
        lblTitulo = new JLabel("FUTQUIZZ");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 19));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto del título
        p1.add(lblTitulo);

        
        // Crear enunciado de texto
        lblEnunciado = new JLabel();
        lblEnunciado.setForeground(Color.WHITE);
        lblEnunciado.setFont(new Font("Arial", Font.BOLD, 16));
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto del enunciado
        p1.add(lblEnunciado);

        // Crear el temporizador
        lblContador = new JLabel("Tiempo: 0s / "+ tiempoescogido + "s");
        lblContador.setFont(new Font("Arial", Font.PLAIN, 16));
        lblContador.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblContador);

        // Mostrar puntos
        lblPuntos = new JLabel("Puntos: 0");
        lblPuntos.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblPuntos);

        // Crear botones de respuesta
        btnRespuesta1 = new JButton();
        btnRespuesta1.setBackground(new Color(255, 204, 204)); // Color rosa claro
        btnRespuesta1.addActionListener(this);
        p2.add(btnRespuesta1);

        btnRespuesta2 = new JButton();
        btnRespuesta2.setBackground(new Color(204, 255, 204)); // Color verde claro
        btnRespuesta2.addActionListener(this);
        p2.add(btnRespuesta2);

        btnRespuesta3 = new JButton();
        btnRespuesta3.setBackground(new Color(204, 204, 255)); // Color azul claro
        btnRespuesta3.addActionListener(this);
        p2.add(btnRespuesta3);

        btnRespuesta4 = new JButton();
        btnRespuesta4.setBackground(new Color(255, 255, 204)); // Color amarillo claro
        btnRespuesta4.addActionListener(this);
        p2.add(btnRespuesta4);
             
        
        // Crear el JLabel para la imagen de la pregunta        
        lblImagenPregunta = new JLabel();
        
        p3.add(lblImagenPregunta);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        
        // Llamar al metodo
        cargarPregunta(dificultad);

        contador = new Thread(this); // Iniciar el hilo con esta instancia
        contador.start(); // Iniciar el hilo después de asignar this

        setVisible(true);
    }

    // METODOS
    // Metodo para cargar aleatoriamente preguntas en los botones
    private void cargarPregunta(String dificultad) {
        try {

            // Conexión a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/retoFutbol", "root", "");

            // Obtener una pregunta aleatori
            PreparedStatement comando = conn.prepareStatement("SELECT * FROM " + dificultad + " ORDER BY RAND() LIMIT 1");
            ResultSet ejecutar_Comando = comando.executeQuery();

            System.out.println(comando);
            System.out.println("La dificultad es: " + dificultad);

            if (ejecutar_Comando.next()) {

                String pregunta = ejecutar_Comando.getString("pregunta");
                String imagenPregunta = ejecutar_Comando.getString("imagenPregunta");
                
                // Configurar la imagen en el JLabel
                if (imagenPregunta != null && !imagenPregunta.isEmpty()) {
                    lblImagenPregunta.setIcon(new ImageIcon(imagenPregunta));
                } else {
                    lblImagenPregunta.setIcon(null); // Si no hay imagen, limpiar el JLabel
                }
               

                String[] respuestas = {

                        ejecutar_Comando.getString("respuestaCorrecta"),

                        ejecutar_Comando.getString("respuestaDos"),

                        ejecutar_Comando.getString("respuestaTres"),

                        ejecutar_Comando.getString("respuestaCuatro")

                };

                // Mostrar la pregunta
                lblEnunciado.setText(pregunta);


                // Guardar la respuesta correcta (la primera)
                correcta = respuestas[0];


                // Mezclar las respuestas de manera aleatoria
                ArrayList<String> respuestasMezcladas = new ArrayList<>(List.of(respuestas));
                Collections.shuffle(respuestasMezcladas);


                btnRespuesta1.setText(respuestasMezcladas.get(0));
                btnRespuesta2.setText(respuestasMezcladas.get(1));
                btnRespuesta3.setText(respuestasMezcladas.get(2));
                btnRespuesta4.setText(respuestasMezcladas.get(3));

                // Resetear los colores de los botones
                resetButtonColors();
            }

            ejecutar_Comando.close();
            comando.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetButtonColors() {
        btnRespuesta1.setBackground(UIManager.getColor("Button.background"));
        btnRespuesta2.setBackground(UIManager.getColor("Button.background"));
        btnRespuesta3.setBackground(UIManager.getColor("Button.background"));
        btnRespuesta4.setBackground(UIManager.getColor("Button.background"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton_clicado = (JButton) e.getSource();
        if (boton_clicado.getText().equals(correcta)) {
            puntos += 8;
            boton_clicado.setBackground(Color.GREEN); // Cambiar color a verde si la respuesta es correcta
        } else {
            puntos -= 4;
            boton_clicado.setBackground(Color.RED); // Cambiar color a rojo si la respuesta es incorrecta
        }

        // Después de un tiempo, cambiar el color del botón nuevamente a su color original
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boton_clicado.setBackground(UIManager.getColor("Button.background"));
                cargarPregunta(dificultad);
            }
        });
        timer.setRepeats(false); // Ejecutar solo una vez
        timer.start();
    }


    private void mostrarDialogo(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }


    @Override
    public void run() {

        for(int i = 0; i < tiempoescogido; i++) {
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();

            }

            tiempo++;

            lblContador.setText(String.valueOf("Tiempo: " + tiempo + "s / " + tiempoescogido + "s"));

            lblPuntos.setText(String.valueOf("Puntos: " + puntos));
        }
        
        int opcion = JOptionPane.showConfirmDialog(this, "Puntos: " + puntos, "¿Quieres jugar de nuevo?", JOptionPane.YES_NO_OPTION);
        
        if(opcion == JOptionPane.YES_OPTION) {
        	Preguntas ventana = new Preguntas("preguntasMedio",40);
        } else {
        	Ranking_elegir r_elegir = new Ranking_elegir(puntos);
        }
        
        // mostrarDialogo("Tiempo: " + tiempo + "s | Puntos: " + puntos);

        setVisible(false);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        new Preguntas("dificultad", 10);
    }
}
