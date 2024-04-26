<?php 

$conex = mysqli_connect("localhost", "root", "", "retoFutbol");

if (!$conex) {
    die('Error de conexión: ' . mysqli_connect_error());
}

?>