import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Ranking_ver extends JFrame implements ActionListener {

    private JLabel lblTitulo;
    private JLabel lblEnunciado;

    private JTable tblVerRanking;
    private DefaultTableModel tableModel;

    private JButton btnSalir;

    JPanel p1, p2;
    
    int p;

    // CONSTRUCTOR
    public Ranking_ver(int puntos) {
    	
    	p = puntos;

        // Configuración básica de la ventana
        setTitle("Ranking | Ver Usuarios");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setBackground(Color.decode("#4CAF50"));

        p2 = new JPanel(new BorderLayout());
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
        lblEnunciado = new JLabel("Ranking de Usuarios");
        lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        p2.add(lblEnunciado, BorderLayout.NORTH);

        // Crear tabla para mostrar el ranking
        tableModel = new DefaultTableModel(new String[]{"Nombre", "Apellido", "Puntos"}, 0);
        tblVerRanking = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblVerRanking);
        p2.add(scrollPane, BorderLayout.CENTER);

        // Crear botón de salir
        btnSalir = new JButton("< Salir");
        btnSalir.addActionListener(this);
        btnSalir.setBackground(Color.decode("#FFC2BC"));
        p2.add(btnSalir, BorderLayout.SOUTH);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setVisible(true);

        // Cargar datos de la base de datos
        cargarDatos();
    }

    private void cargarDatos() {
        String url = "jdbc:mysql://localhost:3306/retoFutbol";
        String user = "root"; // Cambia esto por tu usuario de MySQL
        String password = ""; // Cambia esto por tu contraseña de MySQL

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement("SELECT nombre, apellido, puntos FROM usuarios ORDER BY puntos DESC");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int puntos = rs.getInt("puntos");

                tableModel.addRow(new Object[]{nombre, apellido, puntos});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSalir) {
            dispose();
            Ranking_elegir elegir = new Ranking_elegir(p);
            elegir.setVisible(true);
        }
    }
}
