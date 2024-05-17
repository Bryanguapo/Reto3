<?
include("conex/registro.php");
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FUTQUIZZ | Registro</title>
    <!-- <link rel="stylesheet" href="css/Registro.css"> -->
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="css/general.css">
</head>
<body>
<div class="formulario">
    <div>
        <h2>Registrate</h2>
        <form form name="formulario_registro" method="POST" action="conex/registro.php">

            <label for="Nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required>

            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellido" name="apellido" required>

            <label for="correo">Correo electrónico:</label>
            <input type="email" id="correo" name="correo" required>

            <label for="hora">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required>

            <input type="submit" id="enviar" name="registrarse" value="Registrarse">
            <a id="link" href="Formulario_sesion.php">Iniciar Sesión</a>
        </form>
    </div>
</div>

</body>
</html>