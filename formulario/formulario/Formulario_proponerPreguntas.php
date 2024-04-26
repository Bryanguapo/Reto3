<?
include("conex/registro_pregunta.php");
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrar pregunta</title>
    <!-- <link rel="stylesheet" href="css/Registro.css"> -->
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
</head>
<body>

<div class="formulario">
    <div class="ventana" id="ventana1">
        <h2>¿Que quieres preguntar?</h2>
        <form form name="red_culinary_sushi" method="POST" action="conex/.php">
            <label for="apellidos">Pregunta:</label>
            <input type="text" id="pregunta" name="pregunta" required>

            <label for="apellidos">Respuesta Correcta:</label>
            <input type="text" id="pregunta" name="pregunta" required>

            <label for="apellidos">Respuesta alternativa 2:</label>
            <input type="text" id="pregunta" name="pregunta" required>

            <label for="apellidos">Respuesta alternativa 3:</label>
            <input type="text" id="pregunta" name="pregunta" required>

            <label for="apellidos">Respuesta alternativa 4:</label>
            <input type="text" id="pregunta" name="pregunta" required>

            <input type="submit" name="responder" value="Enviar" style="width: 90px; height: 40px;">
        </form>
    </div>
</div>

</body>
</html>