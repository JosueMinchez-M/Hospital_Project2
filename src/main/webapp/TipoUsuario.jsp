<%-- 
    Document   : TipoUsuario
    Created on : 28/09/2020, 15:58:08
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-5">
            <div class="card col-sm-10">
                <div class ="card-body text-center">
                    <form class ="form-sign" action="ValidarTipoUsuario" method = "POST">
                        <div class ="form-group">
                            <h3>BIENVENIDO AL HOSPITAL</h3>
                            <h4>Tipo de Usiario</h4>
                            <img src="imagenes/TipoPaciente.jpg" alt="70" width="170"/>
                        </div>
                        <div class ="form-group">
                            <input type="radio" name="tipoUsuario" value="paciente">Paciente</p>
                        </div>
                        <div class ="form-group">
                            <input type="radio" name="tipoUsuario" value="medico">Médico</p>                            
                        </div>
                        <div class ="form-group">
                            <input type="radio" name="tipoUsuario" value="laboratorista">Laboratorista</p>
                        </div>
                        <div class ="form-group">
                            <input type="radio" name="tipoUsuario" value="administrador">Administrador</p>
                        </div>
                        <input type="submit" name="btn_ingresar" value="Ingresar" class="btn btn-primary btn_blog">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
