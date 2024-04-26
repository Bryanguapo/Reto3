<?
include("conex/sesion.php");
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <!-- <link rel="stylesheet" href="css/Registro.css"> -->
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
</head>
<body>

<div class="formulario">
    <div class="ventana" id="ventana1">
        <h2>Inicia sesión aquí:</h2>
        <form form name="red_culinary_sushi" method="POST" action="conex/sesion.php">
            <label for="apellidos">Correo:</label>
            <input type="email" id="pregunta" name="correo" required>

            <label for="apellidos">Contraseña:</label>
            <input type="password" id="pregunta" name="contrasena" required>

            <input type="submit" name="sesion" value="Iniciar Sesión" style="width: 90px; height: 40px;">
            <a href="Formulario_registro.php">Registrarse</a>
        </form>
    </div>
</div>

</body>
</html>