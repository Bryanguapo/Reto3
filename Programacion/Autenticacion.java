import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Autenticacion {

	
    public static boolean autenticarUsuario(String correo, String contrasena) {
        
    	boolean autenticado = false;
        
        try {
        	
        	String contrasenaEncriptada = encriptacion(contrasena);
        	
            
            // Conexión a la base de datos
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/retoFutbol", "root", "");

            // Consulta SQL para obtener los datos del usuario
            String sql = "SELECT correo, contrasena FROM usuarios WHERE correo = '" + correo + "' AND contrasena = '" + contrasenaEncriptada + "'";
            PreparedStatement comando = conn.prepareStatement(sql);
            
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {
         
                autenticado = true;
            }
            
            // Cerrar la conexión, el comando y el resultado
            resultado.close();
            comando.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return autenticado;
    }
    
    // Función para verificar la contraseña encriptada
    public static String encriptacion(String contrasena) {

		String contrasenaEncriptada = "";

		try {

			/* Instancia MessageDigest para MD5 */
			MessageDigest m = MessageDigest.getInstance("MD5");

			/* Añadir bytes de texto de la contraseña para digerir con MD5. */
			m.update(contrasena.getBytes());

			/* Convertir el valor hash a bytes */
			byte[] bytes = m.digest();

			/* El array de bytes tiene bytes en forma decimal. Conversion a formato hexadecimal. */
			StringBuilder s = new StringBuilder();

			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			/* Completar contraseña hash en formato hexadecimal */
			contrasenaEncriptada = s.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return contrasenaEncriptada;

	}
    
}
