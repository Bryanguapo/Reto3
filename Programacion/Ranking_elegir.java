
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ranking_elegir extends JFrame implements ActionListener {
	
	private JLabel lblTitulo;
    private JLabel lblEnunciado;
    
    private JLabel lblPuntos;
    private JButton btnInsertarRanking;
    private JButton btnVerRanking;
    private JLabel lblEspacio;
    private JButton btnSalir;
    
    JPanel p1, p2;
    
    int p;
    // CONSTRUCTOR
    public Ranking_elegir(int puntos) {
    	
    	p = puntos;
  
        // Configuración básica de la ventana
        setTitle("Preguntas | Elige una opción");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        p1 = new JPanel();
        p1.setBackground(Color.decode("#4CAF50"));
        
        
        p2 = new JPanel(new GridLayout(6,1));
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
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(lblTitulo);
        
        // Crear enunciado de texto
        lblEnunciado = new JLabel("Juega o crea una pregunta seleccionando aqui");
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblEnunciado);
        
        // Label para ver puntos 
        lblPuntos = new JLabel("Puntos: " + p);
        lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblPuntos);

        // Crear botones de respuesta
        btnInsertarRanking = new JButton("Inserta tus puntos");
        btnInsertarRanking.addActionListener(this);
        p2.add(btnInsertarRanking);

        btnVerRanking = new JButton("Ver ranking");
        btnVerRanking.addActionListener(this);
        p2.add(btnVerRanking);
        
        lblEspacio = new JLabel("");
        p2.add(lblEspacio);
        
        btnSalir = new JButton("< Salir");
        btnSalir.addActionListener(this);
        btnSalir.setBackground(Color.decode("#FFC2BC"));
        p2.add(btnSalir);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInsertarRanking) {
        	dispose();
            Ranking_sesion sesion = new Ranking_sesion(p);
            sesion.setVisible(true);
        }

        if (e.getSource() == btnVerRanking) {
            dispose();
            Ranking_ver ver = new Ranking_ver(p);
            ver.setVisible(true);
        }
        
        if (e.getSource() == btnSalir) {
            dispose();
            Preguntas_elegir elegir = new Preguntas_elegir();
            elegir.setVisible(true);
        }
    }
}
