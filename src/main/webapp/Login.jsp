<%-- 
    Document   : Login
    Created on : 28/09/2020, 13:48:19
    Author     : joshua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <title>Login Hospital</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class ="card-body text-center">
                    <form class ="form-sign" method = "POST" action="">
                        <div class ="form-group">
                            <h3>Login</h3>
                            <img src="imagenes/Login-Hospital.jpg" alt="70" width="150"/>                            
                            <label>Bienvenidos al sistema del Hospital</label>
                        </div>
                        <div class ="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txt_user" class ="form-control">                          
                        </div>
                        <div class ="form-group">
                            <label>Contraseña:</label>
                            <input type="password" name="txt_password" class ="form-control">
                            
                        </div>
                        <input type="submit" name="btn_registrar" value="Registrar" class="btn btn-primary btn_blog">
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
