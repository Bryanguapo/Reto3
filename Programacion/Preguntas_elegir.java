
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Preguntas_elegir extends JFrame implements ActionListener {
	
	private JLabel lblTitulo;
    private JLabel lblEnunciado;
    
    private JButton btnProponer;
    private JButton btnJugar;
    
    JPanel p1, p2;

    // CONSTRUCTOR
    public Preguntas_elegir() {
  
        // Configuración básica de la ventana
        setTitle("Preguntas | Elige una opción");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        p1 = new JPanel();
        p1.setBackground(Color.decode("#4CAF50"));
        
        p2 = new JPanel(new GridLayout(3,1));
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
        lblEnunciado = new JLabel("Juega o crea una pregunta seleccionando aqui");
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblEnunciado);

        // Crear botones de respuesta
        btnProponer = new JButton("Proponer pregunta");
        btnProponer.addActionListener(this);
        p2.add(btnProponer);

        btnJugar = new JButton("Jugar");
        btnJugar.addActionListener(this);
        p2.add(btnJugar);
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnProponer) {
        	dispose();
            Preguntas_sesion sesion = new Preguntas_sesion();
            sesion.setVisible(true);
        }

        if (e.getSource() == btnJugar) {
            dispose();
            Preguntas_dificultad dificultad = new Preguntas_dificultad();
            dificultad.setVisible(true);
        }
    }
}
