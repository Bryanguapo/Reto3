<?
include("conex/registro.php");
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <!-- <link rel="stylesheet" href="css/Registro.css"> -->
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
</head>
<body>
<div class="formulario">
    <div class="ventana" id="ventana1">
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

            <input type="submit" name="registrarse" value="Registrarse" style="width: 90px; height: 40px;">
            <a href="Formulario_sesion.php">Iniciar Sesión</a>
        </form>
    </div>
</div>

</body>
</html>