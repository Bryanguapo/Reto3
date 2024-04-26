<?php 

include("con_db.php");

if (isset($_POST['registrarse'])) {
    if (strlen($_POST['nombre']) >= 1 && strlen($_POST['correo']) >= 1) {
        $nombre = mysqli_real_escape_string($conex, $_POST['nombre']);
        $apellido = mysqli_real_escape_string($conex, $_POST['apellido']);
        $correo = mysqli_real_escape_string($conex, $_POST['correo']);
        $contrasena = password_hash($_POST['contrasena'], PASSWORD_DEFAULT);
        $puntos = 0;
        $fechaJugada = date('Y-m-d');
        
        // Verificar si el correo ya existe
        $verificar_correo = mysqli_query($conex, "SELECT * FROM usuarios WHERE correo = '$correo'");

        if (mysqli_num_rows($verificar_correo) > 0) {
            ?>
            <h3 class="error">El correo ya está registrado</h3>
            <?php
        } else {
            // Agregar la columna de imagen en la consulta
            $consulta = "INSERT INTO usuarios(nombre, apellido, correo, contrasena, puntos, fechaJugada) VALUES ('$nombre', '$apellido', '$correo', '$contrasena', '$puntos', '$fechaJugada')";
        }

        $resultado = mysqli_query($conex, $consulta);

        echo "resultado";

        if ($resultado) {
            ?>
            <h3 class="ok">Te has inscrito correctamente</h3>
            <?php
        } else {
            ?>
            <h3 class="error">ERROR: <?php echo mysqli_error($conex); ?></h3>
            <?php
        }
    } else {
        ?>
        <h3 class="error">Completa los campos</h3>
        <?php
    }
}

?>