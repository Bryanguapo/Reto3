<?php 

session_start();
include("con_db.php");


if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtén las credenciales del formulario y realiza la validación
    $correo = mysqli_real_escape_string($conex, $_POST['correo']);
    $contrasena = mysqli_real_escape_string($conex, $_POST['contrasena']);

    if (empty($correo) || empty($contrasena)) {
        // Manejo de datos incompletos
        echo "Por favor, ingrese tanto el correo como la contraseña.";
        exit();
    }

    // Realiza la consulta para clientes
    $consulta_cliente = "SELECT * FROM usuarios WHERE correo = " . $correo; // Consulta SQL para seleccionar todos los campos de la tabla 'cliente' donde el correo electrónico sea igual al valor proporcionado

    echo $consulta_cliente;

    $stmt_cliente = mysqli_prepare($conex, $consulta_cliente); // Prepara la consulta SQL
    mysqli_stmt_bind_param($stmt_cliente, "s", $correo); // Vincula los parámetros a la consulta preparada
    mysqli_stmt_execute($stmt_cliente); // Ejecuta la consulta preparada
    $resultado_cliente = mysqli_stmt_get_result($stmt_cliente); // Obtiene el resultado de la consulta

    if ($resultado_cliente && mysqli_num_rows($resultado_cliente) > 0) {
        // Si el usuario es un cliente
        $usuarios = mysqli_fetch_assoc($resultado_cliente);
        echo "Credenciales del cliente: " . (password_verify($contrasena, $usuarios['contrasena']) ? 'Correctas' : 'Incorrectas') . "<br>";
        
        if (password_verify($contrasena, $usuarios['contrasena'])) {
            // Almacena datos del cliente en variables de sesión
            $_SESSION['nombre'] = $usuarios['nombre'];
            $_SESSION['idUsuarios'] = $usuarios['idUsuarios'];

            header("Location: Formulario_proponerPreguntas.php");
            exit();
        }
    }

}

// Cierra la conexión a la base de datos y las sentencias preparadas
if (isset($stmt_cliente)) {
    mysqli_stmt_close($stmt_cliente);
}
if (isset($stmt_entrenador)) {
    mysqli_stmt_close($stmt_entrenador);
}

mysqli_close($conex);

?>