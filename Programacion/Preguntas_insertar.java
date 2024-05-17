import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Preguntas_insertar extends JFrame implements ActionListener {
	
	private int idUs;
	
	private JPanel p1, p2;
	private JLabel lblTitulo;
    
    private JLabel lblpregunta, lblrespuestaCorrecta, lblrespuestaDos, lblrespuestaTres, lblrespuestaCuatro;
	
    private JTextField txtpregunta, txtrespuestaCorrecta, txtrespuestaDos, txtrespuestaTres, txtrespuestaCuatro;
	
    private JButton btnenviar;
    
    static String datos [][]= new String [20][6];

    Preguntas_insertar (int idUsuario) {
    	
    	System.out.println("IdUsuario Constructor: " + idUsuario );
    	idUs = idUsuario;
    	
		// Configuración básica de la ventana
        setTitle("Insertar Pregunta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        
        // Crear paneles
        p1 = new JPanel(new GridLayout(1,1));
        p2 = new JPanel(new GridLayout(6,2));
        
        p1.setBackground(Color.decode("#4CAF50"));
        
        // Crear el titulo de texto
        lblTitulo = new JLabel("FUTQUIZZ");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 19));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto del título
        p1.add(lblTitulo);

        
		
		lblpregunta = new JLabel("Pregunta");
		lblrespuestaCorrecta = new JLabel("Respuesta Correcta");
		lblrespuestaDos = new JLabel("Respuesta Dos");
		lblrespuestaTres = new JLabel("Respuesta Tres");
		lblrespuestaCuatro = new JLabel("Respuesta Cuatro");
		
		txtpregunta = new JTextField();
		txtrespuestaCorrecta = new JTextField();
		txtrespuestaDos = new JTextField();
		txtrespuestaTres = new JTextField();
		txtrespuestaCuatro = new JTextField();
		
		btnenviar = new JButton("Enviar");
		btnenviar.addActionListener(this);
		
		p2.add(lblpregunta);
		p2.add(txtpregunta);
		
		p2.add(lblrespuestaCorrecta);
		p2.add(txtrespuestaCorrecta);
		
		p2.add(lblrespuestaDos);
		p2.add(txtrespuestaDos);
		
		p2.add(lblrespuestaTres);
		p2.add(txtrespuestaTres);
		
		p2.add(lblrespuestaCuatro);
		p2.add(txtrespuestaCuatro);
	
		p2.add(btnenviar);
		

		add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        setVisible(true);
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		insertarDatos(idUs);
	}

	public void insertarDatos(int idUs) {
	    String contenidoPregunta = txtpregunta.getText();
	    String contenidoRespuestaCorrecta = txtrespuestaCorrecta.getText();
	    String contenidoRespuestaDos = txtrespuestaDos.getText();
	    String contenidoRespuestaTres = txtrespuestaTres.getText();
	    String contenidoRespuestaCuatro = txtrespuestaCuatro.getText();

	    try {
	        // Conexion a la base de datos
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/retoFutbol", "root", "");

	        // Consulta SQL
	        String sql = "INSERT INTO proponerPreguntas (idUsuarios, idEmpleados, pregunta, respuestaCorrecta, respuestaDos, respuestaTres, respuestaCuatro) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        int idEmpleado = (int) (Math.random() * 5) + 1;
	        
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setInt(1, idUs);
	        stmt.setInt(2, idEmpleado);
	        stmt.setString(3, contenidoPregunta);
	        stmt.setString(4, contenidoRespuestaCorrecta);
	        stmt.setString(5, contenidoRespuestaDos);
	        stmt.setString(6, contenidoRespuestaTres);
	        stmt.setString(7, contenidoRespuestaCuatro);

	        // Ejecutar consulta
	        stmt.executeUpdate();

	        stmt.close(); //cerrar el statement
	        conn.close(); //cerrar la conexión con la base de datos

	        System.out.println("Datos insertados correctamente.");
	        
	    } catch (Exception e) {
	    	System.out.println("IdUsuario: " + idUs);
	        System.out.println("Error al insertar datos: " + e);
	    }
	}

	
	
}