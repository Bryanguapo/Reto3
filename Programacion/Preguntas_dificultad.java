
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Preguntas_dificultad extends JFrame implements ActionListener {
	
	private JLabel lblTitulo;
    private JLabel lblEnunciado;
    
    private JButton btnFacil;
    private JButton btnMedio;
    private JButton btnDificil;
    private JLabel lblEspacio;
    private JButton btnVolver;
    
    private JPanel p1, p2;

    // CONSTRUCTOR
    public Preguntas_dificultad() {
        // Configuración básica de la ventana
        setTitle("Preguntas | Dificultad");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear paneles
        p1 = new JPanel();
        p2 = new JPanel(new GridLayout(6,1));
        
        p1.setBackground(Color.decode("#4CAF50"));
        p2.setBackground(Color.decode("#f0f0f0"));
        
        // Centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        
        // Crear el titulo
        lblTitulo = new JLabel("FUTQUIZZ");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        p1.add(lblTitulo);
        
        // Crear enunciado de texto
        lblEnunciado = new JLabel("Elige aqui la dificultad del juego");
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblEnunciado);

        // Crear botones de dificultad
        btnFacil = new JButton("Fácil");
        btnFacil.addActionListener(this);
        btnFacil.setBackground(Color.decode("#BCFFBE"));
        p2.add(btnFacil);

        btnMedio = new JButton("Medio");
        btnMedio.addActionListener(this);
        btnMedio.setBackground(Color.decode("#BCFFBE"));
        p2.add(btnMedio);
        
        btnDificil = new JButton("Dificil");
        btnDificil.addActionListener(this);
        btnDificil.setBackground(Color.decode("#BCFFBE"));
        p2.add(btnDificil);
        
        lblEspacio = new JLabel();
        p2.add(lblEspacio);
        
        btnVolver = new JButton(" < Volver");
        btnVolver.addActionListener(this);
        btnVolver.setBackground(Color.decode("#FFC2BC"));
        p2.add(btnVolver);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 if (e.getSource() == btnFacil) {
    		 dispose();
    		 int t = 60;
    		 String d = "preguntasFacil";
             Preguntas preguntas = new Preguntas(d,t);
             preguntas.setVisible(true);
             
         }
    	
        if (e.getSource() == btnMedio) {
        	dispose();
        	int t = 40;
        	String d = "preguntasMedio";
            Preguntas preguntas = new Preguntas(d,t);
            preguntas.setVisible(true);
        }

        if (e.getSource() == btnDificil) {
        	dispose();
        	int t = 20;
        	String d = "preguntasDificil";
            Preguntas preguntas = new Preguntas(d,t);
            preguntas.setVisible(true);
          
        }
        
        if (e.getSource() == btnVolver) {
        	dispose();     
            Preguntas_elegir elegir = new Preguntas_elegir();
            elegir.setVisible(true);
          
        }
    }
}
