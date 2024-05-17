<?php 
include("conex/sesion.php");
?>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FUTQUIZZ | Iniciar Sesión</title>
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="css/general.css">
</head>
<body>

<div class="formulario">
    <div>
        <h2>Iniciar sesión</h2>
        <form name="formulario_sesion" method="POST" action="conex/sesion.php">
            <label for="correo">Correo:</label>
            <input type="email" name="correo" required>

            <label for="contrasena">Contraseña:</label>
            <input type="password" name="contrasena" required>

            <input type="submit" id="enviar" name="sesion" value="Iniciar Sesión" >
            <a id="link" href="Formulario_registro.php">Registrarse</a>
        </form>
    </div>
</div>

</body>
</html>
