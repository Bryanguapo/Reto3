<?php 
include("conex/insertarPropuesta.php");
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FUTQUIZZ | Proponer pregunta</title>
    <!-- <link rel="stylesheet" href="css/Registro.css"> -->
    <link rel="icon" href="images/favicon.png" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/general.css">
</head>
<body>

<div class="formulario">
    <div class="column">
        <h1>Hola <?php echo $nombreUsuario; ?></h1>
        <h2>¿Que quieres preguntar?</h2>
        <form class="column" name="formulario_proponerPreguntas" enctype="multipart/form-data" method="POST" action="conex/insertarPropuesta.php">
            <label class="espacio" for="pregunta">Pregunta:</label>
            <input type="text" id="pregunta" name="pregunta" required>
            <label class="espacio_imagen" for="pregunta">Imágen:</label>
            <input type="file" accept="image/png, image/jpeg" name="imagen" >

            <label class="espacio" for="respuesta_correcta"><b>Respuesta</b> correcta:</label>
            <input type="text" name="respuesta_correcta" required>

            <label class="espacio" for="respuesta_dos"><b>Respuesta</b> alternativa 2:</label>
            <input type="text" name="respuesta_dos" >

            <label class="espacio" for="respuesta_tres"><b>Respuesta</b> alternativa 3:</label>
            <input type="text" name="respuesta_tres" >
      
            <label class="espacio" for="respuesta_cuatro"><b>Respuesta</b> alternativa 4:</label>
            <input type="text" name="respuesta_cuatro" >
            

            <input class="espacio" type="submit" name="enviar" value="Enviar" id="enviar">
            <a id="link" href="index.php">Volver</a>
        </form>
    </div>
</div>

</body>
</html>