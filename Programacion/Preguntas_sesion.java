import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Preguntas_sesion extends JFrame implements ActionListener {
	private JLabel lblTitulo;
    private JLabel lblEnunciado;
    
    private JLabel lblEmail;
    private JTextField tfEmail;
    
    private JLabel lblContrasena;
    private JPasswordField pwContrasena;
    
    private JLabel lblEspacio;
    
    private JButton btnEnviar;
    private JLabel lblEspacio_dos;
    private JButton btnVolver;
    
    private JPanel p1, p2;

    // CONSTRUCTOR
    public Preguntas_sesion() {
        // Configuración básica de la ventana
        setTitle("Preguntas | Iniciar Sesión");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setLocation((screenWidth - getWidth()) / 2, (screenHeight - getHeight()) / 2);
        
        // Paneles
        p1 = new JPanel(new GridLayout(1,1));
        p1.setBackground(Color.decode("#4CAF50"));
        
        p2 = new JPanel(new GridLayout(9,1));
        
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        
        
        // Crear el titulo de texto
        lblTitulo = new JLabel("FUTQUIZZ");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto del título
        p1.add(lblTitulo);
        
        // Crear enunciado de texto
        lblEnunciado = new JLabel("Inicia Sesión aquí");
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblEnunciado);

        // Crear enunciado de email
        lblEmail = new JLabel("Email:");
        p2.add(lblEmail);
        // Crear input de email
        tfEmail = new JTextField();
        p2.add(tfEmail);

        // Crear enunciado de contraseña
        lblContrasena = new JLabel("Contraseña:");
        p2.add(lblContrasena);
        // Crear input de contraseña
        pwContrasena = new JPasswordField();
        p2.add(pwContrasena);

        // Espacio
        lblEspacio = new JLabel("");
        p2.add(lblEspacio);

        // Crear botones de respuesta
        btnEnviar = new JButton("Iniciar Sesión");
        btnEnviar.addActionListener(this);
        btnEnviar.setBackground(Color.decode("#BCFFBE"));
        p2.add(btnEnviar);
        
        // Espacio dos
        lblEspacio_dos = new JLabel("");
        p2.add(lblEspacio_dos);
        
        // Crear botones de respuesta
        btnVolver = new JButton(" < Volver");
        btnVolver.addActionListener(this);
        btnVolver.setBackground(Color.decode("#FFC2BC"));
        p2.add(btnVolver);
        
        setVisible(true);
    }

    
    public static int consulta(String correo) throws SQLException {
        int obtenidoIdUsuario = 0;
        
        // Conexion a la base de datos
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/retoFutbol", "root", "");
        
        // Consulta SQL
        String sql = "SELECT idUsuarios FROM usuarios WHERE correo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, correo); // Establecer el valor del parámetro
        
        ResultSet rs = stmt.executeQuery(); // Ejecutar la consulta
        
        if (rs.next()) { // Mover al primer resultado
            obtenidoIdUsuario = rs.getInt("idUsuarios"); // Obtener el valor de la columna idUsuarios
        }
        
        System.out.println(obtenidoIdUsuario);
        
        return obtenidoIdUsuario;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == btnEnviar) {
        	
        	String correo = tfEmail.getText();
        	String contrasena = new String(pwContrasena.getPassword());
        	
        	if (Autenticacion.autenticarUsuario(correo, contrasena)) {
				int IdUsuario = 0;
				try {
					IdUsuario = consulta(correo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
                dispose();
                Preguntas_insertar insertar = new Preguntas_insertar(IdUsuario);
                insertar.setVisible(true); // Mostrar la ventana de preguntas
            } else {
                // Mostrar un mensaje de error si la autenticación falla
                JOptionPane.showMessageDialog(this, "Correo electrónico o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
            }             
        }
        
        if (e.getSource() == btnVolver) {
        	dispose();     
            Preguntas_elegir elegir = new Preguntas_elegir();
            elegir.setVisible(true);
          
        }
    }
}